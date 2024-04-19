package com.pavel.myweather.ui.weatherByCity

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.pavel.myweather.R
import com.pavel.myweather.databinding.FragmentWeatherForDayBinding
import com.pavel.myweather.model.WeatherByDay
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class WeatherForDayByCityFragment : Fragment() {

    private var binding: FragmentWeatherForDayBinding? = null

    private val viewModel: WeatherForDayByCityViewModel by viewModels()



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentWeatherForDayBinding.inflate(inflater)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.goButton?.setOnClickListener {
            findNavController().navigate(R.id.action_weatherForDayFragment_to_weatherForDayByHourFragment)
        }
        viewModel.getWeather()
    }
}