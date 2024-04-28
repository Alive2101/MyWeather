package com.pavel.myweather.repository

import com.pavel.myweather.network.Api
import javax.inject.Inject

class WeatherRepository @Inject constructor(private val api: Api) {
    suspend fun getWeatherByCity(city: String) = api.getWeatherByCity(city)
    suspend fun getWeatherByHour()=api.getWeatherByHour()

    suspend fun getFindCity(city:String)=api.getCity(city)
}