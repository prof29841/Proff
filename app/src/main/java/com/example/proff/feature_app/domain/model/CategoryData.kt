package com.example.proff.feature_app.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class CategoryData(
    val id: Int,
    val image: String,
    val name: String
)
