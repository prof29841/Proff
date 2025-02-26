package com.example.proff.feature_app.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class SomeWorkoutDetails(
    val id: Int,
    val workoutID: Int,
    val workoutTitle: String,
    val workoutTime: String,
    val workoutImage: String
)
