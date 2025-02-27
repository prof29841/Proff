package com.example.proff.feature_app.presentation.AddAlarm

sealed class AddAlarmEvent {

    data object ResetException : AddAlarmEvent()
    data class ChangeVibrateState(val value: Boolean) : AddAlarmEvent()
    data object ChangeIsCompleteState: AddAlarmEvent()

    data object AddAlarm : AddAlarmEvent()
}