package com.example.proff.feature_app.presentation.AddAlarm

data class AddAlarmState(
    val exception: String = "",
    val showIndicator: Boolean = false,
    val isComplete: Boolean = false,

    val sleep: String = "21:00",
    val sleepTime: String = "08:30",

    val isVibrate: Boolean = false,
)
