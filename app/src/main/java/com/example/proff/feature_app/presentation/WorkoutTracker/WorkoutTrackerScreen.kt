package com.example.proff.feature_app.presentation.WorkoutTracker

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.proff.feature_app.presentation.Route
import com.example.proff.feature_app.presentation.common.CustomAlertDialog
import com.example.proff.feature_app.presentation.common.CustomBarChart
import com.example.proff.feature_app.presentation.common.CustomBlueButton
import com.example.proff.feature_app.presentation.common.CustomIndicator
import com.example.proff.feature_app.presentation.common.CustomLightBlueCard
import com.example.proff.feature_app.presentation.common.CustomTopAppBar
import com.example.proff.feature_app.presentation.ui.theme._226F8F
import com.example.proff.feature_app.presentation.ui.theme._81C1CC
import com.example.proff.feature_app.presentation.ui.theme._9CE9EE
import com.example.proff.feature_app.presentation.ui.theme.montserrat40012_B6B4C2
import com.example.proff.feature_app.presentation.ui.theme.montserrat50014_1D1617
import com.example.proff.feature_app.presentation.ui.theme.montserrat60016Bold_1D1617
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
            textColor = Color.White,
            modifier = Modifier
                .padding(horizontal = 30.dp)
        ) { navController.popBackStack()}

        Spacer(Modifier.height(30.dp))

        AnimatedVisibility(
            visible = state.heartRate.isNotEmpty()
        ) {
            CustomBarChart(
                list = state.heartRate,
                barChartColor = _9CE9EE,
                linesColor = Color.White,
                height = 170.dp,
                textColor = Color.White,
            )
        }

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White, RoundedCornerShape(topStart = 40.dp, topEnd = 40.dp))
                .padding(horizontal = 30.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            item {
                Spacer(Modifier.height(30.dp))
                CustomLightBlueCard(
                    text = "Рассписание трен.",
                    btnText = "Проверить"
                ) { navController.navigate(Route.WorkoutScheduleScreen.route) }
                Spacer(Modifier.height(30.dp))
                Text(
                    text = "Что вы хотите тренировать",
                    style = montserrat60016Bold_1D1617
                )
                Spacer(Modifier.height(15.dp))
            }
            items(state.allWorkout){
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(20.dp))
                        .background(Brush.linearGradient(listOf(_81C1CC, _9CE9EE)), RoundedCornerShape(20.dp), 0.2f),
                    colors = CardDefaults.cardColors(Color.Transparent)
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .padding(10.dp)
                    ) {
                        Column {
                            Text(
                                text = it.title,
                                style = montserrat50014_1D1617
                            )
                            Spacer(Modifier.height(5.dp))
                            Text(
                                text = it.description,
                                style = montserrat40012_B6B4C2
                            )
                            Spacer(Modifier.height(15.dp))
                            CustomBlueButton(
                                buttonColor = Color.White,
                                text = "Больше"
                            ) {
                                Route.WorkoutDetails1Screen.workout = it
                                navController.navigate(Route.WorkoutDetails1Screen.route)
                            }
                        }
                    }
                }
                Spacer(Modifier.height(20.dp))
            }
        }
    }

    CustomIndicator(state.showIndicator)
}