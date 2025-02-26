package com.example.proff.feature_app.presentation.Profile

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.proff.feature_app.domain.usecase.User.GetUserDataUseCase
import com.example.proff.feature_app.domain.usecase.User.SetUserImageUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ProfileViewModel(
    private val getUserDataUseCase: GetUserDataUseCase,
    private val setUserImageUseCase: SetUserImageUseCase
) : ViewModel() {

    private val _state = mutableStateOf(ProfileState())
    val state: State<ProfileState> = _state

    init {
        viewModelScope.launch(Dispatchers.IO) {
            _state.value = state.value.copy(showIndicator = true)
            try {
                getUserData()
            } catch (e: Exception) {
                _state.value = state.value.copy(exception = e.message.toString())
            }
            _state.value = state.value.copy(showIndicator = false)
        }
    }

    private suspend fun getUserData() {
        val userData = getUserDataUseCase()
        withContext(Dispatchers.Main){
            _state.value = state.value.copy(userData = userData, image = userData.image)
        }
    }

    fun onEvent(event: ProfileEvent){
        when (event){
            ProfileEvent.ResetException -> {
                _state.value = state.value.copy(exception = "")
            }
            is ProfileEvent.SetImage -> {
                viewModelScope.launch(Dispatchers.IO) {
                    try {
                        setUserImageUseCase(event.value)
                    } catch (e: Exception) {
                        _state.value = state.value.copy(
                            exception = e.message.toString()
                        )
                    }
                }
            }
            is ProfileEvent.SetImageView -> {
                _state.value = state.value.copy(image = event.value)
            }

            is ProfileEvent.SwitchStateChange -> { _state.value = state.value.copy(switchState = event.value) }
        }
    }
}