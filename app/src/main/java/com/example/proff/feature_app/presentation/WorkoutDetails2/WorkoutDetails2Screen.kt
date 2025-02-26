package com.example.proff.feature_app.presentation.WorkoutDetails2

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import co.yml.charts.common.extensions.isNotNull
import coil.compose.AsyncImage
import com.example.proff.feature_app.presentation.Route
import com.example.proff.feature_app.presentation.common.CustomAlertDialog
import com.example.proff.feature_app.presentation.common.CustomBlueButton
import com.example.proff.feature_app.presentation.common.CustomIndicator
import com.example.proff.feature_app.presentation.common.CustomTopAppBar
import com.example.proff.feature_app.presentation.ui.theme.montserrat40012_B6B4C2
import com.example.proff.feature_app.presentation.ui.theme.montserrat40014_226F8F
import com.example.proff.feature_app.presentation.ui.theme.montserrat50012_A5A3B0
import com.example.proff.feature_app.presentation.ui.theme.montserrat60016Bold_1D1617
import org.koin.androidx.compose.koinViewModel

@Composable
fun WorkoutDetails2Screen(
    navController: NavController,
    viewModel: WorkoutDetails2ViewModel = koinViewModel()
) {

    val state = viewModel.state.value
    if (state.exception.isNotEmpty()) {
        CustomAlertDialog(state.exception) {
            viewModel.onEvent(WorkoutDetails2Event.ResetException)
        }
    }


    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(
                start = 30.dp,
                end = 30.dp,
                bottom = (LocalConfiguration.current.screenHeightDp / 20).dp
            )
    ) {
        CustomTopAppBar(
            title = "",
        ) { navController.popBackStack() }

        Spacer(Modifier.height(30.dp))
        AsyncImage(
            model = "https://nnctezenkkdwflrmazcg.supabase.co/storage/v1/object/public/toWork//Video-Section.png",
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp),
            contentScale = ContentScale.Fit
        )
        Spacer(Modifier.height(20.dp))

        AnimatedVisibility(
            visible = state.allWorkoutsData.isNotNull()
        ) {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize(),
                horizontalAlignment = Alignment.Start
            ) {
                item {
                    Text(
                        text = Route.WorkoutDetails1Screen.workout.title,
                        style = montserrat60016Bold_1D1617
                    )
                    Spacer(Modifier.height(5.dp))
                    Text(
                        text = Route.WorkoutDetails1Screen.workout.description,
                        style = montserrat40012_B6B4C2
                    )
                    Spacer(Modifier.height(20.dp))
                    Text(
                        text = "Описание",
                        style = montserrat60016Bold_1D1617
                    )
                    Spacer(Modifier.height(5.dp))
                    Text(
                        text = state.allWorkoutsData!!.description,
                        style = montserrat40012_B6B4C2,
                        textAlign = TextAlign.Left
                    )
                    Spacer(Modifier.height(15.dp))
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .fillMaxWidth()
                    ) {
                        Text(
                            text = "Как это сделать",
                            style = montserrat60016Bold_1D1617
                        )
                        Spacer(Modifier.weight(1f))
                        Text(
                            text = "1 Подход",
                            style = montserrat50012_A5A3B0
                        )
                    }
                    Spacer(Modifier.height(17.dp))
                }

                item {
                    AnimatedVisibility(
                        visible = state.allWorkoutsData.isNotNull()
                    ) {
                        Row(
                            verticalAlignment = Alignment.Top,
                            modifier = Modifier
                                .fillMaxWidth()
                        ) {
                            Text(
                                text = "01",
                                style = montserrat40014_226F8F
                            )
                            Spacer(Modifier.width(10.dp))
                            AsyncImage(
                                model = "https://nnctezenkkdwflrmazcg.supabase.co/storage/v1/object/public/toWork//Group%201.png",
                                contentDescription = null,
                                modifier = Modifier
                                    .height(100.dp),
                                contentScale = ContentScale.Fit
                            )
                            Spacer(Modifier.width(15.dp))
                            Text(
                                text = state.allWorkoutsData!!.description,
                                style = montserrat40012_B6B4C2
                            )
                        }
                    }
                    Spacer(Modifier.height(5.dp))
                    AsyncImage(
                        model = "https://nnctezenkkdwflrmazcg.supabase.co/storage/v1/object/public/toWork//Repetitions-Section.png",
                        contentDescription = null,
                        modifier = Modifier
                            .fillMaxWidth(),
                        contentScale = ContentScale.Crop
                    )
                }

                item {
                    CustomBlueButton(
                        text = "Сохранить",
                        modifier = Modifier
                            .fillMaxWidth()
                    ) {
                        navController.navigate(Route.SuccessRegistrationScreen.route) {
                            popUpTo(Route.WorkoutDetails2Screen.route) {
                                inclusive = true
                            }
                        }
                    }
                }
            }
        }
    }

    CustomIndicator(state.showIndicator)
}