package com.pavel.myweather.ui.weatherForOneWeek.adapter

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.pavel.myweather.databinding.ItemDayForWeekBinding
import com.pavel.myweather.model.WeatherByWeek

class OneWeekViewHolder(private val binding: ItemDayForWeekBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(
        weather: WeatherByWeek
    ) = binding.run {
        dateTextView.text = weather.date
        textTextView.text = weather.text
        temperatureTextView.text = "${weather.temp} \u2103"
        iconImageView.run {
            Glide.with(iconImageView).load(weather.icon).into(this)
        }
    }
}