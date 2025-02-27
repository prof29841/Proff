package com.example.proff.feature_app.presentation.Comparison

import java.time.LocalDate

data class ComparisonState(
    val exception: String = "",
    val showIndicator: Boolean = false,

    val firstMonth: String = LocalDate.now().month.name,
    val secondMonth: String = "Выбрать месяц"
)
