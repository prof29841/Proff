package com.example.proff.feature_app.presentation.ChoosingGoal

sealed class ChoosingGoalEvent {

    data object ResetException: ChoosingGoalEvent()
    data class ChooseGoal(val value: ChoosingGoalItem) : ChoosingGoalEvent()
}