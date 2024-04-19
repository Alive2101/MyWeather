package com.pavel.myweather.ui.weatherForDaybyHour

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pavel.myweather.model.WeatherByHour
import com.pavel.myweather.repository.WeatherRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WeatherForDayByHourViewModel @Inject constructor(
    private val repository: WeatherRepository
) : ViewModel() {

    val listWeather = MutableLiveData<List<WeatherByHour>>()

    fun getWeather() {
        viewModelScope.launch(Dispatchers.IO) {
            val response = repository.getWeatherByHour()
            if (response.isSuccessful) {
//                response.body()?.hour?.map {
//                    WeatherByHour(
//                        temp_c = it.temp_c,
//                        time = it.time
//                    )
//                }.run {
//                    listWeather.postValue(this)
//                }
            }
        }
    }
}