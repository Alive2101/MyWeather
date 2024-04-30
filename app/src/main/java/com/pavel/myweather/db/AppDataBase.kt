package com.pavel.myweather.db

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [CityEntity::class], version = 1)
abstract class AppDataBase:RoomDatabase() {

    abstract fun getCityDao():CityDao
}