package com.pavel.myweather.ui.weatherForTwoWeek

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.pavel.myweather.databinding.FragmentWeatherForTwoWeeksBinding
import com.pavel.myweather.model.WeatherByWeek
import com.pavel.myweather.ui.weatherForTwoWeek.adapter.TwoWeekAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class WeatherForTwoWeekFragment : Fragment() {

    private var binding: FragmentWeatherForTwoWeeksBinding? = null
    private val viewModel: WeatherForTwoWeekViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentWeatherForTwoWeeksBinding.inflate(inflater)
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
            if (adapter == null) {
                layoutManager = LinearLayoutManager(requireContext())
                adapter = TwoWeekAdapter()
            }
            (adapter as? TwoWeekAdapter)?.submitList(list)
        }

    }
}