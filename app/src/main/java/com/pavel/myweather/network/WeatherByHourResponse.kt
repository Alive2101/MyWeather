package com.pavel.myweather.network

data class WeatherByHourResponse(
    val condition: List<Condition>,
    val hour: List<Hour>

)

data class Hour(
    val temp_c: Double,
    val time: String,
)

data class Condition(
    val code: Int,
    val icon: String,
    val text: String
)