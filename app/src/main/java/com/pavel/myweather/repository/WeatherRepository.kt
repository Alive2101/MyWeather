package com.pavel.myweather.repository

import com.pavel.myweather.db.CityDao
import com.pavel.myweather.db.CityEntity
import com.pavel.myweather.model.Safe
import com.pavel.myweather.network.Api
import javax.inject.Inject

class WeatherRepository @Inject constructor(private val api: Api, private val cityDao: CityDao) {
    suspend fun getWeatherByCity(city: String) = api.getWeatherByCity(city)
    suspend fun getWeatherByHour(city: String) = api.getWeatherByHour(city)
    suspend fun getFindCity(city: String) = api.getCity(city)

    suspend fun getWeatherForWeek(
        city: String,
        day: Int
    ) = api.getWeatherForWeeks(city, day)

    suspend fun addCity(city: String) = cityDao.addItem(CityEntity(0, city))

    suspend fun getCityList(): ArrayList<Safe> {
        return (cityDao.getAllItem().map {
            Safe(it.id, it.city)
        } as? ArrayList<Safe>) ?: arrayListOf()
    }

    suspend fun findCity(city: String) = cityDao.findValue(city)

    suspend fun deleteCity(city:String) = cityDao.daleteCity(city)

    suspend fun getWeatherWithDate(city:String,date:String)=api.getWeatherWithDate(city,date)

}