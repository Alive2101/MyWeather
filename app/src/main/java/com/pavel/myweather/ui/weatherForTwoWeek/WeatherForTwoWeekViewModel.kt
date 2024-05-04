package com.pavel.myweather.ui.weatherForTwoWeek

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pavel.myweather.model.WeatherByWeek
import com.pavel.myweather.repository.WeatherRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

private const val DAY = 15
private const val HTTPS = "https:"

@HiltViewModel
class WeatherForTwoWeekViewModel @Inject constructor(
    private val repository: WeatherRepository
) : ViewModel() {
    val listWeather = MutableLiveData<List<WeatherByWeek>>()

    fun getWeather(city: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val response = repository.getWeatherForWeek(city, DAY)
            if (response.isSuccessful) {
                response.body()?.forecast?.forecastday?.map {
                    WeatherByWeek(
                        date = it.date,
                        temp = it.day.avgtemp_c.toString(),
                        text = it.day.condition.text,
                        icon = HTTPS + it.day.condition.icon
                    )
                }.run {
                    listWeather.postValue(this)
                }
            }
        }
    }
}