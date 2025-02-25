package com.example.proff.feature_app.presentation.ChoosingGoal

data class ChoosingGoalState(
    val exception: String = "",
    val showIndicator: Boolean = false,
    val isComplete: Boolean = false,

    val list: List<ChoosingGoalItem> = choosingGoalItemList
)
