package com.pavel.myweather.ui.weatherForOneWeek.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.pavel.myweather.databinding.ItemDayForWeekBinding
import com.pavel.myweather.model.WeatherByWeek

class OneWeekAdapter :
    ListAdapter<WeatherByWeek, OneWeekViewHolder>(object : DiffUtil.ItemCallback<WeatherByWeek>() {
        override fun areItemsTheSame(oldItem: WeatherByWeek, newItem: WeatherByWeek): Boolean {
            return oldItem.date == newItem.date
        }

        override fun areContentsTheSame(oldItem: WeatherByWeek, newItem: WeatherByWeek): Boolean {
            return oldItem.date == newItem.date
        }

    }) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OneWeekViewHolder {
        return OneWeekViewHolder(
            ItemDayForWeekBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: OneWeekViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}