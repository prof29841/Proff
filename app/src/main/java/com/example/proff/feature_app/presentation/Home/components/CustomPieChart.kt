package com.example.proff.feature_app.presentation.Home.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import co.yml.charts.common.model.PlotType
import co.yml.charts.ui.piechart.charts.PieChart
import co.yml.charts.ui.piechart.models.PieChartConfig
import co.yml.charts.ui.piechart.models.PieChartData
import com.example.proff.feature_app.presentation.ui.theme._226F8F

@Composable
fun CustomPieChart(
    value: Float,
    modifier: Modifier = Modifier
) {

    PieChart(
        modifier = modifier,
        pieChartData = PieChartData(
            slices = listOf(
                PieChartData.Slice(
                    label = value.toString(),
                    value = value,
                    color = _226F8F,
                ),
                PieChartData.Slice(
                    label = "",
                    value = 100f - value,
                    color = Color.White,
                ),
            ),
            plotType = PlotType.Pie
        ),
        pieChartConfig = PieChartConfig(labelFontSize = 12.sp, backgroundColor = Color.Transparent)
    )
}