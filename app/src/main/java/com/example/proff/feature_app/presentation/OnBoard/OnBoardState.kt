package com.example.proff.feature_app.presentation.OnBoard

data class OnBoardState(
    val currentPage: Int = 0,
    val list: List<OnBoardItem> = onBoardItemList,

    val isComplete: Boolean = false
)
