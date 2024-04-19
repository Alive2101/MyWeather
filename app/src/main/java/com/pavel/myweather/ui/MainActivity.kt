package com.pavel.myweather.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.pavel.myweather.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //findNavController(R.id.nav_graf).navigate(R.id.action_global_weatherForDayFragment)
    }

}