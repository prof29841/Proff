package com.example.proff.feature_app.presentation.AddWorkoutSchedule

data class AddWorkoutScheduleState(
    val exception: String = "",
    val showIndicator: Boolean = false,

    val dayName: String = "",
    val dayNumber: String = "",
    val monthName : String = "",
    val year: String = ""
)
