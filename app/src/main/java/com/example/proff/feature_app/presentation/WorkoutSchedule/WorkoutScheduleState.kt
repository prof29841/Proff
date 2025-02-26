package com.example.proff.feature_app.presentation.WorkoutSchedule

import com.example.proff.feature_app.domain.model.UserWorkoutSchedule

data class WorkoutScheduleState(
    val exception: String = "",
    val showIndicator: Boolean = false,

    val currentMonth: String = "",
    val currentData: String = "",
    val daysCount: Int = 1,
    val clock: String = "",

    val workoutSchedule: List<UserWorkoutSchedule> = emptyList(),
)
