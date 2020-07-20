package com.isabelledionisius.myomelettapp

import com.isabelledionisius.myomelettapp.networking.RemoteApi
import com.isabelledionisius.myomelettapp.networking.buildApiService
import android.app.Application

private const val KEY_PREFERENCES = "omelett_preferences"
//private const val KEY_TOKEN = "token"

class App : Application() {

    companion object {
        private lateinit var instance: App
        private val apiService by lazy { buildApiService() }
        //val remoteApi by lazy { RemoteApi(apiService) }
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}