package com.example.proff.feature_app.presentation.AddAlarm

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.proff.feature_app.domain.model.SleepScheduleData
import com.example.proff.feature_app.domain.usecase.Sleep.AddSleepDataUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AddAlarmViewModel(
    private val addSleepDataUseCase: AddSleepDataUseCase
) : ViewModel() {

    private val _state = mutableStateOf(AddAlarmState())
    val state: State<AddAlarmState> = _state

    fun onEvent(event: AddAlarmEvent) {
        when (event) {
            AddAlarmEvent.AddAlarm -> {
                viewModelScope.launch(Dispatchers.IO) {
                    try {
                        addSleepDataUseCase(
                            SleepScheduleData(
                                "",
                                _state.value.isVibrate,
                                "Сон, ",
                                _state.value.sleep,
                                _state.value.sleepTime,
                                ""
                            )
                        )
                        addSleepDataUseCase(
                            SleepScheduleData(
                                "",
                                _state.value.isVibrate,
                                "Будильник, ",
                                _state.value.sleep,
                                _state.value.sleepTime,
                                ""
                            )
                        )
                    } catch (e: Exception) {
                        _state.value = state.value.copy(exception = e.message.toString())
                    }

                }
            }

            is AddAlarmEvent.ChangeVibrateState -> {
                _state.value = state.value.copy(isVibrate = event.value)
            }

            AddAlarmEvent.ResetException -> {
                _state.value = state.value.copy(exception = "")
            }

            AddAlarmEvent.ChangeIsCompleteState -> {
                _state.value = state.value.copy(isComplete = !_state.value.isComplete)
            }
        }
    }
}