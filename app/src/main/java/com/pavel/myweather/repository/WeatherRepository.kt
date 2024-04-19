package com.pavel.myweather.repository

import com.pavel.myweather.network.Api
import javax.inject.Inject

class WeatherRepository @Inject constructor(private val api: Api) {
    suspend fun getWeatherByCity() = api.getWeatherByCity()
    suspend fun getWeatherByHour()=api.getWeatherByHour()

    suspend fun getFindCity()=api.getCity()
}