package com.example.proff.feature_app.presentation.ActivityTracker

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.proff.feature_app.domain.usecase.User.GetHeartRateUseCase
import com.example.proff.feature_app.domain.usecase.User.GetLastActivityUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ActivityTrackerViewModel(
    private val getLastActivityUseCase: GetLastActivityUseCase,
    private val getHeartRateUseCase: GetHeartRateUseCase
) : ViewModel() {

    private val _state = mutableStateOf(ActivityTrackerState())
    val state: State<ActivityTrackerState> = _state

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
        val lastActivity = getLastActivityUseCase()

        withContext(Dispatchers.Main){
            _state.value = state.value.copy(
                lastActivity = lastActivity
            )
        }
        val heartRate = getHeartRateUseCase()
        heartRate.value.forEach {
            if (it.isDigit()){
                withContext(Dispatchers.Main){
                    _state.value = state.value.copy(
                        heartRate = _state.value.heartRate.plus(it.toString().toFloat())
                    )
                }
            }
        }
    }

    fun onEvent(event: ActivityTrackerEvent){
        when (event){
            ActivityTrackerEvent.ResetException -> {
                _state.value = state.value.copy(exception = "")
            }
        }
    }
}