package com.nipunapps.moviedb.first_time_display.presentation.view_models

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nipunapps.moviedb.core.Resource
import com.nipunapps.moviedb.first_time_display.domain.model.OnboardingItem
import com.nipunapps.moviedb.first_time_display.domain.repository.FirstTimeDisplayRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OnboardingViewModel @Inject constructor(
    private val firstTimeDisplayRepository: FirstTimeDisplayRepository
) : ViewModel() {

    private val _onboardingItems = MutableStateFlow(emptyList<OnboardingItem>())
    val onboardingItems = _onboardingItems.asStateFlow()

    init {
        fetchOnboarding()
    }

    private fun fetchOnboarding() {
        viewModelScope.launch {
            firstTimeDisplayRepository.getOnboardingItems().onEach { result ->
                when (result) {
                    is Resource.Success -> {
                        _onboardingItems.value = result.data ?: emptyList()
                    }
                    else -> Unit
                }
            }.launchIn(this)
        }
    }


    fun setOnboardingViewed() {
        viewModelScope.launch {
            firstTimeDisplayRepository.setFirstTimeDisplaySettingOver()
        }
    }
}