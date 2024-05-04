package com.pavel.myweather.ui.weatherForDaybyHour.adapter

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.pavel.myweather.databinding.ItemDayByHourBinding
import com.pavel.myweather.model.WeatherByHour

class WeatherForDayByHourViewHolder(private val binding: ItemDayByHourBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(
        weather:WeatherByHour
    ) = binding.run {
        binding.dateTimeTextView.text = weather.time
        binding.temperatureTextView.text = "${weather.temp_c} \u2103"
        binding.signatureTextView.text = weather.text
        iconImageView.run {
            Glide.with(iconImageView).load(weather.icon).into(this)
        }
    }
}