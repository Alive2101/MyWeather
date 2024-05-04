package com.pavel.myweather.reciver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import com.pavel.myweather.controller.NetworkController
import com.pavel.myweather.util.isNetworkConnected
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class NetworkReceiver : BroadcastReceiver() {

    @Inject
    lateinit var networkController: NetworkController

    override fun onReceive(context: Context?, intent: Intent?) {
        val isNetworkConnected: Boolean = context?.isNetworkConnected() == true
        Log.e("NetworkReceiver", "$isNetworkConnected")
        GlobalScope.launch {
            networkController.isNetworkConnected.emit(isNetworkConnected)
        }
    }
}