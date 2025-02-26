package com.example.proff.feature_app.presentation.WorkoutDetails1

import com.example.proff.feature_app.domain.model.SomeWorkoutDetails

data class WorkoutDetails1State(
    val exception: String = "",
    val showIndicator: Boolean = false,

    val details: List<SomeWorkoutDetails> = emptyList(),
    val items: Int = 0,
    val itemsList: List<String> = emptyList()
)
