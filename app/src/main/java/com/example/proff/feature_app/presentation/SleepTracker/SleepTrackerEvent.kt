package com.example.proff.feature_app.presentation.SleepTracker

import com.example.proff.feature_app.domain.model.SleepScheduleData

sealed class SleepTrackerEvent {

    data object ResetException : SleepTrackerEvent()
    data class ChangeSleepTrackerState(val value: SleepScheduleData) : SleepTrackerEvent()
}