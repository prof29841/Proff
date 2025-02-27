package com.example.proff.feature_app.presentation.ProgressPhoto

sealed class ProgressPhotoEvent {

    data object ResetException: ProgressPhotoEvent()
}