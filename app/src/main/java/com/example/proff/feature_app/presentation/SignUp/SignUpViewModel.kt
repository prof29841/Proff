package com.example.proff.feature_app.presentation.SignUp

import android.util.Patterns
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.proff.feature_app.domain.model.UserData
import com.example.proff.feature_app.domain.usecase.Auth.SignUpUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SignUpViewModel(
    private val signUpUseCase: SignUpUseCase
) : ViewModel() {

    private val _state = mutableStateOf(SignUpState())
    val state: State<SignUpState> = _state

    fun onEvent(event: SignUpEvent) {
        when (event) {
            is SignUpEvent.CheckboxStateChange -> {
                _state.value = state.value.copy(
                    checkboxState = event.value
                )
            }

            is SignUpEvent.EmailEnter -> {
                _state.value = state.value.copy(
                    email = event.value
                )
            }

            is SignUpEvent.FioEnter -> {
                _state.value = state.value.copy(
                    fio = event.value
                )
            }

            is SignUpEvent.PasswordEnter -> {
                _state.value = state.value.copy(
                    password = event.value
                )
            }

            is SignUpEvent.PasswordStateChange -> {
                _state.value = state.value.copy(
                    passwordState = event.value
                )
            }

            is SignUpEvent.PhoneEnter -> {
                _state.value = state.value.copy(
                    phone = event.value
                )
            }

            SignUpEvent.ResetException -> {
                _state.value = state.value.copy(
                    exception = ""
                )
            }

            SignUpEvent.SignUp -> {
                if (
                    _state.value.fio.isNotBlank() &&
                    _state.value.phone.isNotBlank() &&
                    _state.value.checkboxState &&
                    Patterns.EMAIL_ADDRESS.matcher(_state.value.email).matches() &&
                    _state.value.password.length >= 6
                ) {
                    viewModelScope.launch(Dispatchers.IO) {
                        _state.value = state.value.copy(showIndicator = true)
                        try {
                            signUpUseCase(
                                _state.value.email,
                                _state.value.password,
                                UserData("", _state.value.fio, _state.value.phone)
                            )
                            _state.value = state.value.copy(isComplete = true)
                        } catch (e: Exception) {
                            _state.value = state.value.copy(exception = e.message.toString())
                        }
                        _state.value = state.value.copy(showIndicator = false)
                    }
                } else {
                    _state.value = state.value.copy(exception = "some data wrong")
                }
            }
        }
    }
}