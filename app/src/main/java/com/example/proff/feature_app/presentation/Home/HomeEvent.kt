package com.example.proff.feature_app.presentation.Home

sealed class HomeEvent {

    data object ResetException : HomeEvent()
}