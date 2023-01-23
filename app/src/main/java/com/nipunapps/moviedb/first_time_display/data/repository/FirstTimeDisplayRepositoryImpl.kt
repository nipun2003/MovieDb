package com.nipunapps.moviedb.first_time_display.data.repository

import android.util.Log
import androidx.datastore.core.DataStore
import com.google.firebase.ktx.Firebase
import com.google.firebase.remoteconfig.ktx.remoteConfig
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.nipunapps.moviedb.core.Constants
import com.nipunapps.moviedb.core.Resource
import com.nipunapps.moviedb.first_time_display.data.local.dto.FirstTimeDisplaySettings
import com.nipunapps.moviedb.first_time_display.domain.model.OnboardingItem
import com.nipunapps.moviedb.first_time_display.domain.repository.FirstTimeDisplayRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class FirstTimeDisplayRepositoryImpl(
    private val firstTimeSettings: DataStore<FirstTimeDisplaySettings>
) : FirstTimeDisplayRepository {

    private val remoteConfig = Firebase.remoteConfig


    override fun getOnboardingItems(): Flow<Resource<List<OnboardingItem>>> = flow {
        try {
            val onboardingStr = remoteConfig.getString(Constants.ON_BOARDING_KEY)
            val gson = Gson()
            val typeToken = object : TypeToken<List<OnboardingItem>>() {}.type
            val onboardingItems = gson.fromJson<List<OnboardingItem>>(
                onboardingStr,
                typeToken
            )
            onboardingItems.forEach {
                Log.e("Item",it.toString())
            }
            emit(Resource.Success<List<OnboardingItem>>(onboardingItems))
        } catch (e: Exception) {
            emit(Resource.Error<List<OnboardingItem>>(e.message.toString()))
        }
    }

    override suspend fun setFirstTimeDisplaySettingOver() {
        firstTimeSettings.updateData { data ->
            data.copy(isOnboardingViewed = true)
        }
    }

    override fun getFirstTimeDisplaySetting(): Flow<FirstTimeDisplaySettings> {
        return firstTimeSettings.data
    }

    override suspend fun deleteDataStore() {
        firstTimeSettings.updateData {
            FirstTimeDisplaySettings()
        }
    }
}