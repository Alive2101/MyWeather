package com.pavel.myweather.ui.weatherForDayByCity

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pavel.myweather.model.WeatherByDay
import com.pavel.myweather.repository.WeatherRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.cancelChildren
import kotlinx.coroutines.launch
import javax.inject.Inject


private const val HTTPS = "https:"

@HiltViewModel
class WeatherForDayByCityViewModel @Inject constructor(
    private val repository: WeatherRepository
) : ViewModel() {

    private var job: Job? = null

    val listWeather = MutableLiveData<WeatherByDay>()

    fun getWeather(city: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val response = repository.getWeatherByCity(city)
            if (response.isSuccessful) {
                val result = response.body()
                val weatherByDay = WeatherByDay(
                    icon = HTTPS + result?.current?.condition?.icon,
                    text = result?.current?.condition?.text ?: "",
                    name = result?.location?.name ?: "",
                    last_updated = result?.current?.last_updated ?: "",
                    temp_c = result?.current?.temp_c ?: "",
                    co = result?.current?.air_quality?.co ?: "",
                    no2 = result?.current?.air_quality?.no2 ?: "",
                    pm10 = result?.current?.air_quality?.pm10 ?: "",
                    pm2_5 = result?.current?.air_quality?.pm2_5 ?: "",
                    o3 = result?.current?.air_quality?.o3 ?: "",
                    so2 = result?.current?.air_quality?.so2 ?: ""
                )
                listWeather.postValue(weatherByDay)
            }
        }
    }



    fun addCity(city: String) {
        job?.cancelChildren()
        job = viewModelScope.launch(Dispatchers.IO) {
            if (repository.findCity(city).isEmpty()) {
                repository.addCity(city)
            }
        }
    }
}
