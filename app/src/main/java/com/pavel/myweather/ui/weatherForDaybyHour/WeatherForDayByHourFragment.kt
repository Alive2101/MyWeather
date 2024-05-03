package com.pavel.myweather.ui.weatherForDaybyHour

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.pavel.myweather.databinding.FragmentWeatherForDayByHourBinding
import com.pavel.myweather.model.WeatherByHour
import com.pavel.myweather.ui.weatherForDaybyHour.adapter.WeatherAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class WeatherForDayByHourFragment : Fragment() {

    private var binding: FragmentWeatherForDayByHourBinding? = null

    private val viewModel: WeatherForDayByHourViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        binding = FragmentWeatherForDayByHourBinding.inflate(inflater)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.listWeather.observe(viewLifecycleOwner) {
            setList(it)
        }
        val city = arguments?.getString("city")
        val date = arguments?.getString("date")
        if (city != null) {
            viewModel.getWeather(city)
        }
        if ((city != null) && (date != null)) {
            Log.e("date and city",date.toString())
            viewModel.getWeatherWithDate(city, date)
        }
    }

    private fun setList(list: List<WeatherByHour>) {
        binding?.recyclerView?.run {
            if (adapter == null) {
                layoutManager = LinearLayoutManager(requireContext())
                adapter = WeatherAdapter()
            }
            (adapter as? WeatherAdapter)?.submitList(list)
        }
    }
}


