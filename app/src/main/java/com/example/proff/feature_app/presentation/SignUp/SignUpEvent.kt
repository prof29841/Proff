package com.example.proff.feature_app.presentation.SignUp

sealed class SignUpEvent {

    data class FioEnter(val value: String) : SignUpEvent()
    data class PhoneEnter(val value: String) : SignUpEvent()
    data class EmailEnter(val value: String) : SignUpEvent()
    data class PasswordEnter(val value: String) : SignUpEvent()
    data class PasswordStateChange(val value: Boolean) : SignUpEvent()
    data class CheckboxStateChange(val value: Boolean) : SignUpEvent()

    data object ResetException: SignUpEvent()
    data object SignUp: SignUpEvent()
}