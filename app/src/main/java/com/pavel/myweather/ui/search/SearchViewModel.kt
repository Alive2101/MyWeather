package com.pavel.myweather.ui.search

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pavel.myweather.model.FindCity
import com.pavel.myweather.repository.WeatherRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val repository: WeatherRepository
) : ViewModel() {

    val listCity = MutableLiveData<List<FindCity>>()
    fun getCity(city: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val response = repository.getFindCity()
            if (response.isSuccessful) {
                response.body()?.cityItem?.map {
                    FindCity(
                        name = it.name
                    )
                }.run {
                    listCity.postValue(this)
                }
            }
        }
    }
}