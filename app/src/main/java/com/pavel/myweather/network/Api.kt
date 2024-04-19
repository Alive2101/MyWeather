package com.pavel.myweather.network

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.PATCH
import retrofit2.http.Path

private const val API_KEY = "4d404820513b49d38d2120522241104"

interface Api {

    @GET("v1/current.json?key=$API_KEY&q=Минск&aqi=yes&lang=ru")
    suspend fun getWeatherByCity(): Response<WeatherByHourResponse>

    @GET("v1/future.json?key=$API_KEY&q=Минск&dt=2024-05-18&lang=ru")
    suspend fun getWeatherByHour(): Response<WeatherByHourResponse>

    @GET("v1/search.json?key=$API_KEY&q=Минск&lang=ru")
    suspend fun getCity(): Response<CityResponse>

}