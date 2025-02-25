package com.example.proff.feature_app.presentation.CreatingProfile

data class CreatingProfileState(
    val exception: String = "",
    val isComplete: Boolean = false,
    val showIndicator: Boolean = false,

    val gender: String = "",
    val birthdayData: String = "",
    val weight: String = "",
    val height: String = "",
)
