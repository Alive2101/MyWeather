package com.pavel.myweather.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface CityDao {

    @Insert
    suspend fun addItem(item: CityEntity)

    @Query("SELECT * FROM CityEntity")
    suspend fun getAllItem(): List<CityEntity>

    @Query("SELECT * FROM CityEntity WHERE city = :city")
    suspend fun findValue(city: String): List<CityEntity>

    @Query("DELETE FROM CityEntity WHERE city = :city")
    suspend fun daleteCity(city:String)

}