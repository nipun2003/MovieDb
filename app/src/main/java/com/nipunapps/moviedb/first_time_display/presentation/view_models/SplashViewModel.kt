package com.nipunapps.moviedb.first_time_display.presentation.view_models

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nipunapps.moviedb.first_time_display.data.local.dto.FirstTimeDisplaySettings
import com.nipunapps.moviedb.first_time_display.domain.repository.FirstTimeDisplayRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
    private val firstTimeDisplayRepository: FirstTimeDisplayRepository
) : ViewModel() {

    private val _appRemember = MutableStateFlow(FirstTimeDisplaySettings())
    val appRemember = _appRemember.asStateFlow()

    init {
        getAppRemembers()
    }

    private fun getAppRemembers() {
        firstTimeDisplayRepository.getFirstTimeDisplaySetting().onEach {
            _appRemember.value = it
        }.launchIn(viewModelScope)
    }
}