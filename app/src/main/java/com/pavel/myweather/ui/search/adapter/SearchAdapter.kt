package com.pavel.myweather.ui.search.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.pavel.myweather.databinding.ItemCityBinding
import com.pavel.myweather.model.FindCity

class SearchAdapter(
    private val onCityClick: (city: String) -> Unit
) :
    ListAdapter<FindCity, SearchViewHolder>(object : DiffUtil.ItemCallback<FindCity>() {
        override fun areItemsTheSame(oldItem: FindCity, newItem: FindCity): Boolean {
            return oldItem.name == newItem.name
        }

        override fun areContentsTheSame(oldItem: FindCity, newItem: FindCity): Boolean {
            return oldItem.name == newItem.name
        }

    }) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchViewHolder {
        return SearchViewHolder(
            ItemCityBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) {
        holder.bind(getItem(position),onCityClick)
        holder.itemView.setOnClickListener {
            onCityClick(getItem(position).name)
        }

    }
}
