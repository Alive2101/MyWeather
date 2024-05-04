package com.pavel.myweather.ui.weatherForDaybyHour.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.pavel.myweather.databinding.ItemDayByHourBinding
import com.pavel.myweather.model.WeatherByHour

class WeatherForDayByHourAdapter :
    ListAdapter<WeatherByHour, WeatherForDayByHourViewHolder>(object : DiffUtil.ItemCallback<WeatherByHour>() {
        override fun areItemsTheSame(oldItem: WeatherByHour, newItem: WeatherByHour): Boolean {
            return oldItem.time == newItem.time
        }

        override fun areContentsTheSame(oldItem: WeatherByHour, newItem: WeatherByHour): Boolean {
            return oldItem == newItem
        }

    }) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherForDayByHourViewHolder {
        return WeatherForDayByHourViewHolder(
            ItemDayByHourBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: WeatherForDayByHourViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}
