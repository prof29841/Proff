package com.example.proff.feature_app.presentation.Profile

sealed class ProfileEvent {

    data object ResetException : ProfileEvent()
    data class SetImageView(val value: String) : ProfileEvent()
    data class SetImage(val value: ByteArray) : ProfileEvent()
    data class SwitchStateChange(val value: Boolean) : ProfileEvent()
}