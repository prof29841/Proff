package com.example.proff.feature_app.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class Gallery(
    val userID: String,
    val photo: String,
    val id: Int = 0,
)
