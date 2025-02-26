package com.example.proff.feature_app.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class AllWorkoutsData(
    val id: Int,
    val title: String,
    val description: String,
    val image: String,
    val items: String
)
