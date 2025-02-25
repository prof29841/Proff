package com.example.proff.feature_app.presentation.common

import androidx.compose.foundation.layout.Row
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.proff.feature_app.presentation.ui.theme.montserrat40014_1D1617
import com.example.proff.feature_app.presentation.ui.theme.montserrat50014_9CE9EE

@Composable
fun CustomTextButton(
    firstText: String,
    secondText: String,
    enabled: Boolean = true,
    modifier: Modifier = Modifier,
    onclick: () -> Unit
) {

    TextButton(
        onClick = onclick,
        modifier = modifier,
        enabled = enabled,
        colors = ButtonDefaults.textButtonColors(Color.Transparent)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = firstText,
                style = montserrat40014_1D1617
            )
            Text(
                text = secondText,
                style = montserrat50014_9CE9EE
            )
        }
    }
}