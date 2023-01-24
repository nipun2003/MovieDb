package com.nipunapps.moviedb.feature_auth.presentation.view_models

import androidx.lifecycle.ViewModel
import com.nipunapps.moviedb.feature_auth.domain.repository.RegisterRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class RegistrationViewModel @Inject constructor(
    private val registerRepository: RegisterRepository
) : ViewModel(){

    private val _username = MutableStateFlow("")
    val username = _username.asStateFlow()


}