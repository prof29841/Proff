package com.example.proff.feature_app.presentation.Comparison

sealed class ComparisonEvent {

    data object ResetException: ComparisonEvent()
    data class SelectFirstMonth(val value: String) : ComparisonEvent()
    data class SelectSecondMonth(val value: String) : ComparisonEvent()
}