package com.example.proff.feature_app.presentation.ActivityTracker.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.proff.feature_app.presentation.ui.theme._F7F8F8
import com.example.proff.feature_app.presentation.ui.theme.montserrat40010White
import com.example.proff.feature_app.presentation.ui.theme.montserrat40012White
import com.example.proff.feature_app.presentation.ui.theme.montserrat40012_B6B4C2

@Composable
fun CustomActivityBarChart(
    list: List<Float>,
    barChartColor: Color,
    height: Dp = 180.dp,
    modifier: Modifier = Modifier
) {

    val weekList = listOf(
        "Пн",
        "Вт",
        "Ср",
        "Чт",
        "Пт",
        "Сб",
        "Вс",
    )

    Column(
        modifier
    ) {
        Row {
            Canvas(Modifier.height(height)) {
                val width = 20.dp.toPx()
                list.forEachIndexed { index, i ->
                    val height = (i / list.max()) * size.height
                    val x = (width*index) + 20.dp.toPx()*index
                    val y = size.height - height

                    drawRoundRect(
                        _F7F8F8,
                        topLeft = Offset(x, 0f),
                        Size(width, size.height),
                        cornerRadius = CornerRadius(20.dp.toPx())
                    )

                    drawRoundRect(
                        color = barChartColor,
                        topLeft = Offset(x, y),
                        size = Size(width, height),
                        cornerRadius = CornerRadius(20.dp.toPx())
                    )
                }
            }
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = modifier
        ) {
            repeat(weekList.size){
                Text(
                    text = weekList[it],
                    style = montserrat40012_B6B4C2
                )
            }
        }
    }
}