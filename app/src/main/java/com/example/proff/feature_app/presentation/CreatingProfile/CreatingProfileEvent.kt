package com.example.proff.feature_app.presentation.CreatingProfile

sealed class CreatingProfileEvent {

    data class GenderEnter(val value: String) : CreatingProfileEvent()
    data class BirthdayDataEnter(val value: String) : CreatingProfileEvent()
    data class WeightEnter(val value: String) : CreatingProfileEvent()
    data class HeightEnter(val value: String) : CreatingProfileEvent()

    data object ResetException : CreatingProfileEvent()
    data object CreateProfile : CreatingProfileEvent()
}