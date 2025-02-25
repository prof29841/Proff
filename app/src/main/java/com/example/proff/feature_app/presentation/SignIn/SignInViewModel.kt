package com.example.proff.feature_app.presentation.SignIn

import android.util.Patterns
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.proff.feature_app.domain.usecase.Auth.SignInUseCase
import com.example.proff.feature_app.domain.usecase.Auth.SignInWithGoogleUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SignInViewModel(
    private val signInUseCase: SignInUseCase,
    private val signInWithGoogleUseCase: SignInWithGoogleUseCase
) : ViewModel() {

    private val _state = mutableStateOf(SignInState())
    val state: State<SignInState> = _state

    fun onEvent(event: SignInEvent){
        when (event){
            is SignInEvent.EmailEnter -> {
                _state.value = state.value.copy(email = event.value)
            }
            is SignInEvent.PasswordEnter -> {
                _state.value = state.value.copy(password = event.value)
            }
            is SignInEvent.PasswordStateChange -> {
                _state.value = state.value.copy(passwordState = event.value)
            }
            SignInEvent.ResetException -> {
                _state.value = state.value.copy(exception = "")
            }
            SignInEvent.SignIn -> {
                _state.value = state.value.copy(showIndicator = true)
                if (
                    _state.value.email.isNotBlank() &&
                    Patterns.EMAIL_ADDRESS.matcher(_state.value.email).matches()
                ){
                    if (
                        _state.value.password.length >= 6
                    ){
                        _state.value = state.value.copy(showIndicator = true)
                        try {

                        } catch (e: Exception) {
                            _state.value = state.value.copy(exception = e.message.toString())
                            _state.value = state.value.copy(showIndicator = false)
                        }
                        _state.value = state.value.copy(showIndicator = false)
                    }else{
                        _state.value = state.value.copy(exception = "пароль не должен быть меньше 6 символов")
                    }
                }else{
                    _state.value = state.value.copy(exception = "неверный email")
                }
                _state.value = state.value.copy(showIndicator = false)
            }
            SignInEvent.SignInWithGoogle -> {
                viewModelScope.launch(Dispatchers.IO) {
                    _state.value = state.value.copy(showIndicator = true)
                    try {
                        if (signInWithGoogleUseCase()){
                            _state.value = state.value.copy(isComplete = true)
                        }else{
                            _state.value = state.value.copy(exception = "user not founded")
                        }
                    } catch (e: Exception) {
                        _state.value = state.value.copy(exception = e.message.toString())
                        _state.value = state.value.copy(showIndicator = false)
                    }
                    _state.value = state.value.copy(showIndicator = false)
                }
            }
        }
    }
}