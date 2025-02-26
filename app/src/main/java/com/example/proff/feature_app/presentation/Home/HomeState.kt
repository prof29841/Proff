package com.example.proff.feature_app.presentation.Home

import com.example.proff.feature_app.domain.model.UserData

data class HomeState(
    val exception: String = "",
    val showIndicator: Boolean = false,

    val userData: UserData? = null,

    val heartRate: List<Float> = emptyList(),
    val massBodyIndex: Float = 0.0f
)
