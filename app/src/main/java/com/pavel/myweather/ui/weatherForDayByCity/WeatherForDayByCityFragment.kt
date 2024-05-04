package com.pavel.myweather.ui.weatherForDayByCity

import android.annotation.SuppressLint
import android.app.DatePickerDialog
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
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

private const val DAY = 30
private const val MONTH = 2
private const val MINDAY = 15

@AndroidEntryPoint
class WeatherForDayByCityFragment : Fragment() {

    private var binding: FragmentWeatherForDayByCityBinding? = null
    private val viewModel: WeatherForDayByCityViewModel by viewModels()
    private val calendar = Calendar.getInstance()
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
            heartImageView.setOnClickListener {
                if (city != null) {
                    viewModel.addCity(city)
                }
            }
            hourButton.setOnClickListener {
                findNavController().navigate(
                    R.id.action_weatherForDayByCityFragment_to_weatherForDayByHourFragment2,
                    args
                )
            }
            oneWeekButton.setOnClickListener {
                findNavController().navigate(
                    R.id.action_weatherForDayByCityFragment_to_weatherForOneWeekFragment,
                    args
                )
            }
            twoWeekButton.setOnClickListener {
                findNavController().navigate(
                    R.id.action_weatherForDayByCityFragment_to_weatherForTwoWeekFragment,
                    args
                )
            }
            checkDateButton.setOnClickListener {
                showDatePicker()
            }
        }
    }

    @SuppressLint("SetTextI18n")
    private fun observeViewModel() {
        viewModel.listWeather.observe(viewLifecycleOwner) {
            binding?.run {
                textTextView.text = it.text
                iconWeatherImageView.run {
                    Glide.with(iconWeatherImageView).load(it.icon).into(iconWeatherImageView)
                }
                cityTextView.text = it.name
                temperatureTextView.text = "${resources.getString(R.string.temperature)} ${it.temp_c} \u2103"
                lastUpdateTextView.text =
                    "${resources.getString(R.string.last_update)} ${it.last_updated}"
                carbonMonoxideTextView.text =
                    "${resources.getString(R.string.carbon_monoxide)} ${it.co} ${
                        resources.getString(R.string.hg)
                    }"
                ozoneTextView.text = "${resources.getString(R.string.ozone)} ${it.o3} ${
                    resources.getString(R.string.hg)
                }"
                nitrogenDioxideTextView.text =
                    "${resources.getString(R.string.nitrogen_dioxide)} ${it.no2} ${
                        resources.getString(R.string.hg)
                    }"
                sulphurDioxideTextView.text =
                    "${resources.getString(R.string.sulphur_dioxide)} ${it.so2} ${
                        resources.getString(R.string.hg)
                    }"
                pm25TextView.text = "${resources.getString(R.string.pm2_5)} ${it.pm2_5} ${
                    resources.getString(R.string.hg)
                }"
                pm10TextView.text = "${resources.getString(R.string.pm10)} ${it.pm10} ${
                    resources.getString(R.string.hg)
                }"
            }
        }
    }

    private fun showDatePicker() {
        val args = Bundle()
        val city = arguments?.getString("city")
        val datePickerDialog = DatePickerDialog(
            requireContext(), { DatePicker, year: Int, monthOfYear: Int, dayOfMonth: Int ->
                val selectedDate = Calendar.getInstance()
                selectedDate.set(year, monthOfYear, dayOfMonth)
                val dateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
                val formattedDate = dateFormat.format(selectedDate.time)
                args.putString("date", formattedDate)
                args.putString("city", city)
                Log.e("date1", formattedDate.toString())
                findNavController().navigate(
                    R.id.action_weatherForDayByCityFragment_to_weatherForDayByHourFragment2,
                    args
                )
            },
            calendar.get(Calendar.YEAR),
            calendar.get(Calendar.MONTH),
            calendar.get(Calendar.DAY_OF_MONTH)
        )
        val minDay = calendar.get(Calendar.DAY_OF_MONTH) + MINDAY
        val minMonth = calendar.get(Calendar.MONTH)
        val minYear = calendar.get(Calendar.YEAR)
        calendar.set(minYear, minMonth, minDay)
        datePickerDialog.datePicker.minDate = calendar.timeInMillis

        val maxDay = minDay + DAY
        val maxMonth = minMonth + MONTH
        calendar.set(minYear, maxMonth - 1, maxDay)
        datePickerDialog.datePicker.maxDate = calendar.timeInMillis
        datePickerDialog.show()
    }
}


