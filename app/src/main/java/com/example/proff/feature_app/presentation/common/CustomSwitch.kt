package com.example.proff.feature_app.presentation.common

import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.proff.feature_app.presentation.ui.theme._226F8F
import com.example.proff.feature_app.presentation.ui.theme._C4C4C4

@Composable
fun CustomSwitch(
    state: Boolean,
    enabled: Boolean = true,
    modifier: Modifier = Modifier,
    onClick: (Boolean) -> Unit,
) {
    Switch(
        checked = state,
        onCheckedChange = onClick,
        modifier = modifier,
        enabled = enabled,
        colors = SwitchDefaults.colors(
            checkedThumbColor = Color.White,
            uncheckedThumbColor = Color.White,
            checkedTrackColor = _226F8F,
            uncheckedTrackColor = _C4C4C4,
            checkedBorderColor = Color.Transparent,
            uncheckedBorderColor = Color.Transparent,
        )
    )
}