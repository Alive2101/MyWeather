package com.pavel.myweather.network

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

private const val API_KEY = "dd0198ddd66c4bd8beb170723242804"

interface Api {
    @GET("v1/current.json?key=$API_KEY&aqi=yes&lang=ru")
    suspend fun getWeatherByCity(@Query("q") city: String): Response<WeatherHourAndWeekResponse>

    @GET("v1/forecast.json?key=$API_KEY&lang=ru&days=1&aqi=no&alerts=no")
    suspend fun getWeatherByHour(
        @Query("q") city: String
    ): Response<WeatherHourAndWeekResponse>

    @GET("v1/search.json?key=$API_KEY&lang=ru")
    suspend fun getCity(@Query("q") city: String): Response<FindCityResponse>

    @GET("v1/forecast.json?key=$API_KEY&aqi=no&alerts=no&lang=ru")
    suspend fun getWeatherForWeeks(
        @Query("q") city: String,
        @Query("days") day: Int
    ): Response<WeatherHourAndWeekResponse>
}