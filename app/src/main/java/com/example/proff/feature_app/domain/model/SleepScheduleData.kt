package com.example.proff.feature_app.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class SleepScheduleData(
    val userID: String,
    val enabled: Boolean,
    val title: String,
    val sleepTime: String,
    val sleepEnd: String,
    val date: String,
    val id: Int = 0,
)
