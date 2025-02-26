package com.example.proff.feature_app.presentation.CategoryBreakfast

import com.example.proff.feature_app.domain.model.CategoryData

data class CategoryBreakfastState(
    val exception: String = "",
    val showIndicator: Boolean = false,

    val categories: List<CategoryData> = emptyList()
)
