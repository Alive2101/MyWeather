package com.pavel.myweather.network

class FindCityResponse : ArrayList<FindCityResponseItem>()

data class FindCityResponseItem(
    val id: Int,
    val name: String
)