package com.nipunapps.moviedb

import android.app.Application
import android.util.Log
import com.google.firebase.FirebaseApp
import com.google.firebase.ktx.Firebase
import com.google.firebase.ktx.initialize
import com.google.firebase.remoteconfig.FirebaseRemoteConfig
import com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings
import com.google.firebase.remoteconfig.ktx.remoteConfig
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MovieApp : Application() {

    override fun onCreate() {
        super.onCreate()
        initializeRemoteConfig()
    }

    private fun initializeRemoteConfig() {
        Firebase.initialize(this)
        Firebase.remoteConfig.apply {
            //set this during development
            val configSettings = FirebaseRemoteConfigSettings.Builder()
                .setMinimumFetchIntervalInSeconds(0)
                .build()
            setConfigSettingsAsync(configSettings)
            //set this during development

            setDefaultsAsync(R.xml.remote_config_defaults)
            fetchAndActivate().addOnCompleteListener { task ->
                val updated = task.result
                if (task.isSuccessful) {
                    val updated = task.result
                    Log.d("TAG", "Config params updated: $updated")
                } else {
                    Log.d("TAG", "Config params updated: $updated")
                }
            }
        }
    }
}