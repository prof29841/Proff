package com.example.proff.feature_app.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class Notifications(
    val userID: String,
    val title: String,
    val time: String,
    val image: String,

    val id: Int = 0
)
