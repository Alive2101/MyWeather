package com.pavel.myweather.network

data class Hour(
    val air_quality: AirQuality,
    val condition: Condition,
    val temp_c: String,
    val time: String
)