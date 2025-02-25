package com.example.proff.feature_app.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class LastActivity(
    val userID: String,
    val title: String,
    val description: String,

    val id: Int = 0,
)
