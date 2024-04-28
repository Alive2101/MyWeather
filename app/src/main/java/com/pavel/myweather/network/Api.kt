package com.pavel.myweather.network

import retrofit2.Response
import retrofit2.http.GET

import retrofit2.http.Query

private const val API_KEY = "dd0198ddd66c4bd8beb170723242804"

interface Api {

    @GET("v1/current.json?key=$API_KEY&aqi=yes&lang=ru")
    suspend fun getWeatherByCity(@Query("q") city: String): Response<WeatherByHourResponse>

    @GET("v1/future.json?key=$API_KEY&q=Минск&dt=2024-05-18&lang=ru")
    suspend fun getWeatherByHour(): Response<DayByHourResponse>

    @GET("v1/search.json?key=$API_KEY&lang=ru")
    suspend fun getCity(@Query("q") city:String): Response<FindCityResponse>

}