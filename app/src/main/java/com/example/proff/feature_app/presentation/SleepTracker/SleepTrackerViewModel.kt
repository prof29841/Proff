package com.example.proff.feature_app.presentation.SleepTracker

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.proff.feature_app.domain.usecase.Sleep.ChangeSleepEnabledUseCase
import com.example.proff.feature_app.domain.usecase.Sleep.GetSleepDataUseCase
import com.example.proff.feature_app.domain.usecase.User.GetHeartRateUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class SleepTrackerViewModel(
    private val getHeartRateUseCase: GetHeartRateUseCase,
    private val getSleepDataUseCase: GetSleepDataUseCase,
    private val changeSleepEnabledUseCase: ChangeSleepEnabledUseCase
) : ViewModel() {

    private val _state = mutableStateOf(SleepTrackerState())
    val state: State<SleepTrackerState> = _state

    init {
        viewModelScope.launch(Dispatchers.IO) {
            _state.value = state.value.copy(showIndicator = true)
            try {
                getUserData()
            } catch (e: Exception) {
                _state.value = state.value.copy(
                    exception = e.message.toString()
                )
            }
            _state.value = state.value.copy(showIndicator = false)
        }
    }

    private suspend fun getUserData() {
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

        try {
            val sleep = getSleepDataUseCase()
            withContext(Dispatchers.Main){
                _state.value = state.value.copy(sleepSchedule = sleep)
            }
        } catch (_: Exception) {
            _state.value = state.value.copy(exception = "data not founded")
        }
    }

    fun onEvent(event: SleepTrackerEvent){
        when (event){
            is SleepTrackerEvent.ChangeSleepTrackerState -> {
                viewModelScope.launch(Dispatchers.IO) {
                    try {
                        changeSleepEnabledUseCase(event.value)
                    } catch (e: Exception) {
                        _state.value = state.value.copy(exception = e.message.toString())
                    }
                }
            }
            SleepTrackerEvent.ResetException -> {
                _state.value = state.value.copy(exception = "")
            }
        }
    }
}