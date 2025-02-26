package com.example.proff.feature_app.presentation.WorkoutTracker

import com.example.proff.feature_app.domain.model.AllWorkoutsData
import com.example.proff.feature_app.domain.model.HeartRate
import com.example.proff.feature_app.domain.model.UserWorkoutTracker

data class WorkoutTrackerState(
    val exception: String = "",
    val showIndicator: Boolean = false,

    val userWorkout: List<UserWorkoutTracker> = emptyList(),
    val allWorkout: List<AllWorkoutsData> = emptyList(),

    val heartRate: List<Float> = emptyList()
)
