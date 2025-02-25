package com.example.proff.feature_app.presentation.common

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.proff.feature_app.presentation.ui.theme._DDDADA
import com.example.proff.feature_app.presentation.ui.theme.montserrat40012_1D1617

@Composable
fun CustomHorizontalDivider(
    wordBetweenLines: String = "Или",
    lineColors: Color = _DDDADA,
    modifier: Modifier = Modifier
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
    ) {
        Box(Modifier.weight(1f).height(1.dp).background(lineColors))
        Spacer(Modifier.width(5.dp))
        Text(
            text = wordBetweenLines,
            style = montserrat40012_1D1617
        )
        Spacer(Modifier.width(5.dp))
        Box(Modifier.weight(1f).height(1.dp).background(lineColors))
    }
}