package com.pavel.myweather.repository

import com.pavel.myweather.network.Api
import javax.inject.Inject

class WeatherRepository @Inject constructor(private val api: Api) {
    suspend fun getWeatherByCity(city: String) = api.getWeatherByCity(city)
    suspend fun getWeatherByHour(city: String)=api.getWeatherByHour(city)
    suspend fun getFindCity(city:String)=api.getCity(city)

    suspend fun getWeatherForWeek(city: String,day:Int)=api.getWeatherForWeeks(city,day)

}