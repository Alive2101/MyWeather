package com.pavel.myweather.ui.weatherByCity

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pavel.myweather.model.WeatherByDay
import com.pavel.myweather.repository.WeatherRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WeatherForDayByCityViewModel @Inject constructor(
    private val repository: WeatherRepository
) : ViewModel() {

    val listWeather = MutableLiveData<WeatherByDay>()

    fun getWeather(city: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val response = repository.getWeatherByCity(city)
            if (response.isSuccessful) {
                val temp = response.body()
                val weatherByDay = WeatherByDay(
                    icon = "https:" + temp?.current?.condition?.icon,
                    text = temp?.current?.condition?.text ?: "",
                    name = temp?.location?.name ?: "",
                    last_updated = temp?.current?.last_updated ?: "",
                    temp_c = temp?.current?.temp_c ?: "",
                    co = temp?.current?.air_quality?.co ?:"",
                    no2 = temp?.current?.air_quality?.no2 ?:"",
                    pm10 = temp?.current?.air_quality?.pm10 ?:"",
                    pm2_5 = temp?.current?.air_quality?.pm2_5 ?:"",
                    o3 = temp?.current?.air_quality?.o3?:"",
                    so2 = temp?.current?.air_quality?.so2 ?:""
                )
                listWeather.postValue(weatherByDay)
            } else {

            }
        }
    }
}
