package com.pavel.myweather.ui.weatherByCity

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.pavel.myweather.R
import com.pavel.myweather.databinding.FragmentWeatherForDayByCityBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class WeatherForDayByCityFragment : Fragment() {

    private var binding: FragmentWeatherForDayByCityBinding? = null
    private val viewModel: WeatherForDayByCityViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentWeatherForDayByCityBinding.inflate(inflater)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val args = Bundle()
        val city = arguments?.getString("city")
        if (city != null) {
            viewModel.getWeather(city)
            args.putString("city", city)
        }
        observeViewModel()
        binding?.run {
            hourButton.setOnClickListener {
                findNavController().navigate(
                    R.id.action_weatherForDayByCityFragment_to_weatherForDayByHourFragment2,
                    args
                )
            }
        }
    }

    private fun observeViewModel() {
        viewModel.listWeather.observe(viewLifecycleOwner) {
            binding?.run {
                textTextView.text = it.text
                iconWeatherImageView.run {
                    Glide.with(iconWeatherImageView).load(it.icon).into(iconWeatherImageView)
                }
                cityTextView.text = it.name
                temperatureTextView.text = it.temp_c
                lastUpdateTextView.text = it.last_updated
                carbonMonoxideTextView.text = it.co
                ozoneTextView.text = it.o3
                nitrogenDioxideTextView.text = it.no2
                sulphurDioxideTextView.text = it.so2
                pm25TextView.text = it.pm2_5
                pm10TextView.text = it.pm10
            }
        }
    }
}


