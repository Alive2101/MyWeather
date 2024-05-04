package com.pavel.myweather.ui.search

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pavel.myweather.controller.NetworkController
import com.pavel.myweather.model.FindCity
import com.pavel.myweather.repository.WeatherRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val repository: WeatherRepository,
    networkController: NetworkController
) : ViewModel() {

    val isNetworkConnected = MutableLiveData<Boolean>()

    val listCity = MutableLiveData<List<FindCity>>()

    init {
        viewModelScope.launch {
            networkController.isNetworkConnected.collectLatest {
                isNetworkConnected.value = it
            }
        }
    }

    fun getCity(city: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val response = repository.getFindCity(city)
            if (response.isSuccessful) {
                response.body()?.map {
                    FindCity(
                        name = it.name
                    )
                }?.run {
                    listCity.postValue(this)
                }
            }
        }
    }
}