package com.nipunapps.moviedb.first_time_display.domain.repository

import com.nipunapps.moviedb.core.Resource
import com.nipunapps.moviedb.first_time_display.data.local.dto.FirstTimeDisplaySettings
import com.nipunapps.moviedb.first_time_display.domain.model.OnboardingItem
import kotlinx.coroutines.flow.Flow

interface FirstTimeDisplayRepository {

    suspend fun setFirstTimeDisplaySettingOver()

    fun getOnboardingItems() : Flow<Resource<List<OnboardingItem>>>

    fun getFirstTimeDisplaySetting(): Flow<FirstTimeDisplaySettings>

    suspend fun deleteDataStore()
}