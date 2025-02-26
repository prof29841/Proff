package com.example.proff.feature_app.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class UserWorkoutSchedule(
    val userID: String,
    val date: String,
    val title: String,
    val time: String,
    val id: Int = 0,
)
