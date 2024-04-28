package com.pavel.myweather.ui.search.adapter

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.pavel.myweather.databinding.ItemCityBinding
import com.pavel.myweather.model.FindCity

class SearchViewHolder(private val binding: ItemCityBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(
        findCity: FindCity, onCityClick: (city: String) -> Unit
    ) = binding.run {
        cityTextView.text = findCity.name
        cityTextView.setOnClickListener {
            onCityClick(findCity.name)
        }
    }
}