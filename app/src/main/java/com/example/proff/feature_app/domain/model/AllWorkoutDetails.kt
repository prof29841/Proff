package com.example.proff.feature_app.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class AllWorkoutDetails(
    val id: Int,
    val workoutID: Int,
    val level: String,
    val description: String,
    val howDoIt: String
)
