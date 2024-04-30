package com.pavel.myweather.ui.safeCity

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pavel.myweather.model.Safe
import com.pavel.myweather.repository.WeatherRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.cancelChildren
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SelectedCitiesViewModel @Inject constructor(
    private val repository: WeatherRepository
) : ViewModel() {

    private var job: Job? = null
    val listCity = MutableLiveData<List<Safe>>()

    fun loadSafeCity() {
        job?.cancelChildren()
        job = viewModelScope.launch(Dispatchers.IO) {
            listCity.postValue(repository.getCityList())
        }
    }

    fun deleteCity(city: String) {
        job?.cancelChildren()
        job = viewModelScope.launch(Dispatchers.IO) {
            repository.deleteCity(city)
        }
    }
}