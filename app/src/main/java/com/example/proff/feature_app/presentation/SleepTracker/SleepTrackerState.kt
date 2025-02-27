package com.example.proff.feature_app.presentation.SleepTracker

import com.example.proff.feature_app.domain.model.SleepScheduleData

data class SleepTrackerState(
    val exception: String = "",
    val showIndicator: Boolean = false,

    val heartRate: List<Float> = emptyList(),
    val sleepSchedule: List<SleepScheduleData> = emptyList()
)
