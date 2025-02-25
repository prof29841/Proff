package com.example.proff.feature_app.presentation.common

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import com.example.proff.feature_app.presentation.ui.theme._226F8F
import com.example.proff.feature_app.presentation.ui.theme._CFCFCF

@Composable
fun CustomIndicator(
    state: Boolean,
    modifier: Modifier = Modifier
) {
    AnimatedVisibility(
        visible = state,
        enter = fadeIn(tween(500)),
        exit = fadeOut(tween(500))
    ) {
        Box(
            Modifier
                .fillMaxSize()
                .background(Brush.linearGradient(listOf(_CFCFCF, _CFCFCF)), alpha = 0.3f),
            contentAlignment = Alignment.Center
        ){
            CircularProgressIndicator(
                color = _226F8F,
                modifier = modifier
            )
        }
    }
}