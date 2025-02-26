package com.example.proff.feature_app.presentation.WorkoutDetails2

import com.example.proff.feature_app.domain.model.AllWorkoutDetails

data class WorkoutDetails2State(
    val exception: String = "",
    val showIndicator: Boolean = false,

    val allWorkoutsData: AllWorkoutDetails? = null,
)
