package com.pavel.myweather.network


data class Current(
    val air_quality: AirQuality,
    val condition: Condition,
    val last_updated: String,
    val temp_c: String,
)