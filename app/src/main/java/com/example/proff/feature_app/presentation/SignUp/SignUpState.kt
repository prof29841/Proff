package com.example.proff.feature_app.presentation.SignUp

data class SignUpState(
    val exception: String = "",
    val showIndicator: Boolean = false,
    val isComplete: Boolean = false,
    val checkboxState: Boolean = false,

    val passwordState: Boolean = true,

    val fio: String = "",
    val phone: String ="",
    val email: String = "",
    val password: String = "",
)
