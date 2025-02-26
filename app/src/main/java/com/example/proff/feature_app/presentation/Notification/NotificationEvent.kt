package com.example.proff.feature_app.presentation.Notification

sealed class NotificationEvent {

    data object ResetException : NotificationEvent()
}