package com.pavel.myweather.network

data class Day(
    val air_quality: AirQuality,
    val avgtemp_c: Double,
    val condition: Condition
)