package com.example.proff.feature_app.presentation.ProgressPhoto

import com.example.proff.feature_app.domain.model.Gallery

data class ProgressPhotoState(
    val exception: String = "",
    val showIndicator: Boolean = false,

    val photos: List<Gallery> = emptyList(),
)
