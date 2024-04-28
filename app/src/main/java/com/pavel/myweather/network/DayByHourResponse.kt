package com.pavel.myweather.network

data class DayByHourResponse(
    val forecast: Forecast,
    val location: Location
)

data class Hour(
    val condition: Condition_,
    val temp_c: String,
    val time: String,
)
data class Forecastday(
    val date: String,
    val date_epoch: Int,
    val hour: List<Hour>
)
data class Forecast(
    val forecastday: List<Forecastday>
)

data class Condition_(
    val text: String
)
