package com.nipunapps.moviedb.feature_auth.presentation.view_models

import androidx.lifecycle.ViewModel
import com.nipunapps.moviedb.feature_auth.domain.repository.RegisterRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(
    private val registerRepository: RegisterRepository
) : ViewModel() {

    private val _emailState = MutableStateFlow("")
    val emailState = _emailState.asStateFlow()

    private val _passwordState = MutableStateFlow("")
    val passwordState = _passwordState.asStateFlow()

    fun onEmailChange(value: String) {
        _emailState.value = value
    }

    fun onPasswordChange(value: String) {
        _passwordState.value = value
    }
}