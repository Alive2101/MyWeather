package com.pavel.myweather.ui.weatherForOneWeek.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.pavel.myweather.databinding.ItemDayForWeekBinding
import com.pavel.myweather.model.WeatherByWeek

class WeatherForOneWeekAdapter :
    ListAdapter<WeatherByWeek, WeatherForOneWeekViewHolder>(object : DiffUtil.ItemCallback<WeatherByWeek>() {
        override fun areItemsTheSame(oldItem: WeatherByWeek, newItem: WeatherByWeek): Boolean {
            return oldItem.date == newItem.date
        }

        override fun areContentsTheSame(oldItem: WeatherByWeek, newItem: WeatherByWeek): Boolean {
            return oldItem.date == newItem.date
        }

    }) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherForOneWeekViewHolder {
        return WeatherForOneWeekViewHolder(
            ItemDayForWeekBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: WeatherForOneWeekViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}