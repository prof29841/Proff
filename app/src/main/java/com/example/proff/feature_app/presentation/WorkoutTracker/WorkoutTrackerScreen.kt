package com.example.proff.feature_app.presentation.WorkoutTracker

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.proff.feature_app.presentation.common.CustomAlertDialog
import com.example.proff.feature_app.presentation.common.CustomBarChart
import com.example.proff.feature_app.presentation.common.CustomIndicator
import com.example.proff.feature_app.presentation.common.CustomTopAppBar
import com.example.proff.feature_app.presentation.ui.theme._226F8F
import com.example.proff.feature_app.presentation.ui.theme._81C1CC
import com.example.proff.feature_app.presentation.ui.theme._9CE9EE
import org.koin.androidx.compose.koinViewModel

@Composable
fun WorkoutTrackerScreen(
    navController: NavController,
    viewModel: WorkoutTrackerViewModel = koinViewModel()
) {

    val state = viewModel.state.value
    if (state.exception.isNotEmpty()) {
        CustomAlertDialog(state.exception) {
            viewModel.onEvent(WorkoutTrackerEvent.ResetException)
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Brush.linearGradient(listOf(_81C1CC, _226F8F))),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CustomTopAppBar(
            title = "Трекер тренировок",
            textColor = Color.White
        ) { navController.popBackStack()}

        Spacer(Modifier.height(30.dp))

        AnimatedVisibility(
            visible = state.heartRate.isNotEmpty()
        ) {
            CustomBarChart(
                list = state.heartRate,
                barChartColor = _9CE9EE,
                linesColor = Color.White,

            )
        }
    }

    CustomIndicator(state.showIndicator)
}