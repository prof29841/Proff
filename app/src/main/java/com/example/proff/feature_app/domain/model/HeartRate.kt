package com.example.proff.feature_app.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class HeartRate(
    val userID: String,
    val value: String,

    val id: Int = 0,
)
