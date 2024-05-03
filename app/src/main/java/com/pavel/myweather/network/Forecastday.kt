package com.pavel.myweather.network

data class Forecastday(
    val date: String,
    val day: Day,
    val hour: List<Hour>
)