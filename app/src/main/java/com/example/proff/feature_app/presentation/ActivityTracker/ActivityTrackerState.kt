package com.example.proff.feature_app.presentation.ActivityTracker

import com.example.proff.feature_app.domain.model.LastActivity

data class ActivityTrackerState(
    val exception: String = "",
    val showIndicator: Boolean = false,

    val heartRate: List<Float> = emptyList(),
    val lastActivity: List<LastActivity> = emptyList(),
)
