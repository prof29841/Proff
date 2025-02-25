package com.example.proff.feature_app.presentation.SignIn

sealed class SignInEvent {

    data class EmailEnter(val value: String) : SignInEvent()
    data class PasswordEnter(val value: String) : SignInEvent()
    data class PasswordStateChange(val value: Boolean) : SignInEvent()

    data object ResetException: SignInEvent()
    data object SignIn: SignInEvent()
    data object SignInWithGoogle: SignInEvent()
}