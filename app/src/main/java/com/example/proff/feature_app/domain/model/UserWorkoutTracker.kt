package com.example.proff.feature_app.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class UserWorkoutTracker(
    val userID: String,

    val title: String,
    val date: String,
    val enabled: Boolean,
    val image: String,
    val id: Int = 0,
)
