package com.pavel.myweather.ui.weatherByCity

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pavel.myweather.model.WeatherByDay
import com.pavel.myweather.repository.WeatherRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.json.JSONObject
import javax.inject.Inject

@HiltViewModel
class WeatherForDayByCityViewModel @Inject constructor(
    private val repository: WeatherRepository
) : ViewModel() {

    val listWeather = MutableLiveData<List<WeatherByDay>>()

    fun getWeather() {
        viewModelScope.launch(Dispatchers.IO) {

            val response = repository.getWeatherByCity()
            if (response.isSuccessful) {
                //                response.body()?.condition?.map {
//                    WeatherByDay(
//                        icon = it.icon,
//                        text = it.text
//                    )
//                }.run {
//                    listWeather.postValue(this)
//                }
            }
        }
    }
}