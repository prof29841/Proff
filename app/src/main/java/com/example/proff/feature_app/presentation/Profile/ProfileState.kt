package com.example.proff.feature_app.presentation.Profile

import com.example.proff.feature_app.domain.model.UserData

data class ProfileState(
    val exception: String = "",
    val showIndicator: Boolean = false,

    val userData: UserData? = null,
    val switchState: Boolean = false,

    val image: String = "",
)
