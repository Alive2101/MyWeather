package com.pavel.myweather.ui.weatherForTwoWeek.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.pavel.myweather.databinding.ItemDayForWeekBinding
import com.pavel.myweather.model.WeatherByWeek

class TwoWeekAdapter :
    ListAdapter<WeatherByWeek, TwoWeekViewHolder>(object : DiffUtil.ItemCallback<WeatherByWeek>() {
    override fun areItemsTheSame(oldItem: WeatherByWeek, newItem: WeatherByWeek): Boolean {
        return oldItem.date == newItem.date
    }

    override fun areContentsTheSame(oldItem: WeatherByWeek, newItem: WeatherByWeek): Boolean {
        return oldItem.date == newItem.date
    }

}) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TwoWeekViewHolder {
        return TwoWeekViewHolder(
            ItemDayForWeekBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: TwoWeekViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}