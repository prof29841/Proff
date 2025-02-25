package com.example.proff.feature_app.presentation.SuccessRegistration

sealed class SuccessRegistrationEvent {

    data object ResetException : SuccessRegistrationEvent()
}
