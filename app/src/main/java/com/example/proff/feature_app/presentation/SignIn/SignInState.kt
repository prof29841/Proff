package com.example.proff.feature_app.presentation.SignIn

data class SignInState(
    val exception: String ="",
    val showIndicator: Boolean = false,

    val email: String = "",
    val password: String = "",

    val passwordState: Boolean = true,
    val isComplete: Boolean = false,
)
