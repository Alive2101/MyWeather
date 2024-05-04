package com.pavel.myweather.di

import android.content.Context
import androidx.room.Room
import com.pavel.myweather.db.AppDataBase
import com.pavel.myweather.db.CityDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideDB(@ApplicationContext context:Context):AppDataBase{
        return Room.databaseBuilder(context, AppDataBase::class.java,"dataBase").build()
    }

    @Singleton
    @Provides
    fun provideCityDao(appDataBase: AppDataBase):CityDao{
        return appDataBase.getCityDao()
    }
}