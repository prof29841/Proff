package com.example.proff.feature_app.presentation.SleepSchedule

import com.example.proff.feature_app.domain.model.SleepScheduleData

sealed class SleepScheduleEvent{

    data object ResetException : SleepScheduleEvent()

    data class ChangeEnabled(val sleepScheduleData: SleepScheduleData) : SleepScheduleEvent()
}
