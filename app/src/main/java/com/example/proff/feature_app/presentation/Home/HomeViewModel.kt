package com.example.proff.feature_app.presentation.Home

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.proff.feature_app.domain.usecase.User.GetHeartRateUseCase
import com.example.proff.feature_app.domain.usecase.User.GetUserDataUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class HomeViewModel(
    private val getUserDataUseCase: GetUserDataUseCase,
    private val getHeartRateUseCase: GetHeartRateUseCase
) : ViewModel() {

    private val _state = mutableStateOf(HomeState())
    val state: State<HomeState> = _state

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
        val massBodyIndex =
            userData.weight.toFloat() / (userData.height.toFloat() / 100 * userData.height.toFloat() / 100)

        withContext(Dispatchers.Main) {
            _state.value = state.value.copy(
                userData = userData,
                massBodyIndex = massBodyIndex
            )
        }

        val heartRate = getHeartRateUseCase()
        withContext(Dispatchers.Main){
            heartRate.value.forEach {
                if (it.isDigit()){
                    _state.value = state.value.copy(heartRate = _state.value.heartRate.plus(it.toString().toFloat()))
                }
            }
        }
    }

    fun onEvent(event: HomeEvent) {
        when (event) {
            HomeEvent.ResetException -> {
                _state.value = state.value.copy(exception = "")
            }
        }
    }
}