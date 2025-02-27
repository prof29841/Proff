package com.example.proff.feature_app.presentation.SleepSchedule

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.proff.feature_app.domain.usecase.Sleep.ChangeSleepEnabledUseCase
import com.example.proff.feature_app.domain.usecase.Sleep.GetSleepDataUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class SleepScheduleViewModel(
    private val getSleepDataUseCase: GetSleepDataUseCase,
    private val changeSleepEnabledUseCase: ChangeSleepEnabledUseCase
) : ViewModel() {

    private val _state = mutableStateOf(SleepScheduleState())
    val state: State<SleepScheduleState> = _state

    init {
        viewModelScope.launch(Dispatchers.IO) {
            _state.value = state.value.copy(showIndicator = true)
            try {
                getSleepData()
            } catch (e: Exception) {
                _state.value = state.value.copy(exception = e.message.toString())
            }
            _state.value = state.value.copy(showIndicator = false)
        }
    }

    private suspend fun getSleepData() {
        val sleep = getSleepDataUseCase()

        withContext(Dispatchers.Main){
            _state.value = state.value.copy(sleepSchedule = sleep)
        }
    }

    fun onEvent(event: SleepScheduleEvent){
        when (event){
            SleepScheduleEvent.ResetException -> {

                _state.value = state.value.copy(exception = "")
            }

            is SleepScheduleEvent.ChangeEnabled -> {
                viewModelScope.launch(Dispatchers.IO) {
                    try {
                        changeSleepEnabledUseCase(event.sleepScheduleData)
                    } catch (e: Exception) {
                        _state.value = state.value.copy(exception = e.message.toString())
                    }
                }
            }
        }
    }
}