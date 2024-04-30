package com.pavel.myweather.ui.weatherForDaybyHour.adapter

import androidx.recyclerview.widget.RecyclerView
import com.pavel.myweather.databinding.ItemDayByHourBinding
import com.pavel.myweather.model.WeatherByHour

class WeatherViewHolder(private val binding: ItemDayByHourBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(
        weather:WeatherByHour
    ) = binding.run {
        binding.dateTimeTextView.text = weather.time
        binding.temperatureTextView.text = weather.temp_c
        binding.signatureTextView.text = weather.text
    }
}