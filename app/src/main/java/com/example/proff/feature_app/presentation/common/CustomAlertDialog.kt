package com.example.proff.feature_app.presentation.common

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.dp
import com.example.proff.feature_app.presentation.ui.theme._226F8F
import com.example.proff.feature_app.presentation.ui.theme.montserrat40014_B6B4C2
import com.example.proff.feature_app.presentation.ui.theme.montserrat70024Bold_1D1617

@Composable
fun CustomAlertDialog(
    description: String,
    title: String = "Ошибка!",
    modifier: Modifier = Modifier,
    tag: String = "dialog",
    dismissClick: () -> Unit,
) {
    AlertDialog(
        onDismissRequest = dismissClick,
        confirmButton = {},
        modifier = modifier
            .testTag(tag),
        icon = {
            Box(
                Modifier
                    .clip(CircleShape)
                    .background(_226F8F, CircleShape),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Default.Warning,
                    contentDescription = null,
                    tint = Color.White,
                    modifier = Modifier
                        .padding(10.dp)
                )
            }
        },
        title = {
            Text(
                text = title,
                style = montserrat70024Bold_1D1617
            )
        },
        text = {
            Text(
                text = description,
                style = montserrat40014_B6B4C2
            )
        },
        containerColor = Color.White
    )
}