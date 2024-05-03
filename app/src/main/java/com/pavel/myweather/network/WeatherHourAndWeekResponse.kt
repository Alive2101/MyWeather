package com.pavel.myweather.network

data class WeatherHourAndWeekResponse(
    val current: Current,
    val forecast: Forecast,
    val location: Location
)

data class Current(
    val air_quality: AirQuality,
    val condition: Condition,
    val last_updated: String,
    val temp_c: String,
)

data class AirQuality(
    val co: String,
    val no2: String,
    val o3: String,
    val pm10: String,
    val pm2_5: String,
    val so2: String
)

data class Day(
    val air_quality: AirQuality,
    val avgtemp_c: Double,
    val condition: Condition
)

data class Forecastday(
    val date: String,
    val day: Day,
    val hour: List<Hour>
)

data class Condition(
    val code: Double,
    val icon: String,
    val text: String
)

data class Forecast(
    val forecastday: List<Forecastday>
)

data class Location(
    val name: String
)

data class Hour(
    val air_quality: AirQuality,
    val condition: Condition,
    val temp_c: String,
    val time: String
)