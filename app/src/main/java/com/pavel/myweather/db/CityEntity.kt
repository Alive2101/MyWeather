package com.pavel.myweather.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "CityEntity")
class CityEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    @ColumnInfo("city")
    val city: String
)