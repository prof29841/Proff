package com.example.proff.feature_app.presentation.common

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
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
import com.example.proff.feature_app.presentation.ui.theme.montserrat40010White
import com.example.proff.feature_app.presentation.ui.theme.montserrat40012White

@Composable
fun CustomBarChart(
    list: List<Float>,
    barChartColor: Color,
    linesColor: Color,
    height: Dp = 130.dp,
    textColor: Color,
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

                    repeat(7){
                        if (it != 0){
                            drawLine(
                                color = linesColor,
                                start = Offset(0f, (size.height / 6) * index),
                                end = Offset(size.width, (size.height / 6) * index),
                                strokeWidth = 1.dp.toPx()
                            )
                        }
                    }

                    drawRoundRect(
                        color = barChartColor,
                        topLeft = Offset(x, y),
                        size = Size(width, height),
                        cornerRadius = CornerRadius(10.dp.toPx())
                    )
                }
            }
            Spacer(Modifier.weight(1f))
            LazyColumn(
                Modifier
                    .height(height),
                reverseLayout = true,
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                items(6){
                    Text(
                        text = "${it * 20}%",
                        style = montserrat40010White,
                        color = textColor
                    )
                }
            }
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = modifier
        ) {
            repeat(weekList.size){
                Text(
                    text = weekList[it],
                    style = montserrat40012White,
                    color = textColor,
                    modifier = Modifier
                        .offset(x = ((20.dp * it) + 5.dp * it))
                )
            }
        }
    }
}