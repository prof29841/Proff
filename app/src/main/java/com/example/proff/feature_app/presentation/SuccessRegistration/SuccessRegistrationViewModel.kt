package com.example.proff.feature_app.presentation.SuccessRegistration

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.proff.feature_app.domain.usecase.User.GetUserDataUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class SuccessRegistrationViewModel(
    private val getUserDataUseCase: GetUserDataUseCase
) : ViewModel() {

    private val _state = mutableStateOf(SuccessRegistrationState())
    val state: State<SuccessRegistrationState> = _state

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
            _state.value = state.value.copy(userFio = userData.fio)
        }
    }

    fun onEvent(event: SuccessRegistrationEvent){
        when (event){
            SuccessRegistrationEvent.ResetException -> {
                _state.value = state.value.copy(exception = "")
            }
        }
    }
}