package com.pavel.myweather.ui.weatherForOneWeek

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.pavel.myweather.databinding.FragmentWeatherForOneWeekBinding
import com.pavel.myweather.model.WeatherByWeek
import com.pavel.myweather.ui.weatherForOneWeek.adapter.WeatherForOneWeekAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class WeatherForOneWeekFragment : Fragment() {

    private var binding: FragmentWeatherForOneWeekBinding? = null
    private val viewModel: WeatherForOneWeekViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentWeatherForOneWeekBinding.inflate(inflater)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.listWeather.observe(viewLifecycleOwner) {
            setList(it)
        }
        val city = arguments?.getString("city")
        if (city != null) {
            viewModel.getWeather(city)
        }
    }

    private fun setList(list: List<WeatherByWeek>) {
        binding?.recyclerView?.run {
            if(adapter == null){
                layoutManager = LinearLayoutManager(requireContext())
                adapter = WeatherForOneWeekAdapter()
            }
            (adapter as? WeatherForOneWeekAdapter)?.submitList(list)
        }

    }

}