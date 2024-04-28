package com.pavel.myweather.network

data class WeatherByHourResponse(
    val current: Current,
    val location: Location
)

data class Location(
    val name: String
)
data class Current(
    val air_quality: AirQuality,
    val condition: Condition,
    val last_updated: String,
    val temp_c: String
)

 data class Condition(
    val code: Int,
    val icon: String,
    val text: String
)
data class AirQuality(
    val co: String,
    val no2: String,
    val o3: String,
    val pm10: String,
    val pm2_5: String,
    val so2: String
)