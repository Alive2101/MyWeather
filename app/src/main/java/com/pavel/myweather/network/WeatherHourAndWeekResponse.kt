package com.pavel.myweather.network

data class WeatherHourAndWeekResponse(
    val current: Current,
    val forecast: Forecast,
    val location: Location
)