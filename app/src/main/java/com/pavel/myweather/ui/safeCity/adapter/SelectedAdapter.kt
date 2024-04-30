package com.pavel.myweather.ui.safeCity.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.pavel.myweather.databinding.ItemCityForSafeBinding
import com.pavel.myweather.model.Safe

class SelectedAdapter(
    private val onCityInfo: (city: String) -> Unit,
    private val onDeleteCity: (city: String) -> Unit
) :
    ListAdapter<Safe, SelectedViewHolder>(object : DiffUtil.ItemCallback<Safe>() {
        override fun areItemsTheSame(oldItem: Safe, newItem: Safe): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Safe, newItem: Safe): Boolean {
            return oldItem == newItem
        }
    }) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SelectedViewHolder {
        return SelectedViewHolder(
            ItemCityForSafeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )

    }

    override fun onBindViewHolder(holder: SelectedViewHolder, position: Int) {
        holder.bind(getItem(position), onCityInfo, onDeleteCity)
    }


}