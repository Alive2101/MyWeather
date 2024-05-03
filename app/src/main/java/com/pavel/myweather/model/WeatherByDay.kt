package com.pavel.myweather.model


data class WeatherByDay(
    val name: String,
    val last_updated: String,
    val temp_c: String,
    val icon: String,
    val text: String,
    val co: String,
    val no2: String,
    val o3: String,
    val pm10: String,
    val pm2_5: String,
    val so2: String
)