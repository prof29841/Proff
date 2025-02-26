package com.example.proff.feature_app.presentation.Home.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun HomeBarChart(
    list: List<Float>,
    barChartColor: Color,
    height: Dp = 80.dp,
    modifier: Modifier = Modifier
) {
    Canvas(modifier.height(height)) {
        val width = 20.dp.toPx()
        list.forEachIndexed { index, i ->
            val height = (i / list.max()) * size.height
            val x = (width * index) + 5.dp.toPx() * index
            val y = size.height - height

            drawRoundRect(
                color = barChartColor,
                topLeft = Offset(x, y),
                size = Size(width, height),
                cornerRadius = CornerRadius(10.dp.toPx())
            )
        }
    }
}