package com.pavel.myweather.ui.safeCity.adapter

import androidx.recyclerview.widget.RecyclerView
import com.pavel.myweather.databinding.ItemCityForSafeBinding
import com.pavel.myweather.model.Safe

class SelectedViewHolder(
    private val binding: ItemCityForSafeBinding
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(
        safe: Safe, onCityInfo: (city: String) -> Unit,
        onDeleteCity: (city: String) -> Unit
    ) {
        binding.run {
            cityTextView.text = safe.city
            cityTextView.setOnClickListener {
                onCityInfo(safe.city)
            }
            crackHeartImageView.setOnClickListener {
                onDeleteCity(safe.city)
            }
        }
    }
}