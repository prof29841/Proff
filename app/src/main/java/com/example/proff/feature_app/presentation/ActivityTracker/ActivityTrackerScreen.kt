package com.example.proff.feature_app.presentation.ActivityTracker

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
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
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.proff.feature_app.presentation.ActivityTracker.components.CustomActivityBarChart
import com.example.proff.feature_app.presentation.ActivityTracker.components.CustomCurrentPurpose
import com.example.proff.feature_app.presentation.ActivityTracker.components.CustomLAstActivityCard
import com.example.proff.feature_app.presentation.common.CustomAlertDialog
import com.example.proff.feature_app.presentation.common.CustomBlueButton
import com.example.proff.feature_app.presentation.common.CustomIndicator
import com.example.proff.feature_app.presentation.common.CustomTopAppBar
import com.example.proff.feature_app.presentation.ui.theme._1D161712
import com.example.proff.feature_app.presentation.ui.theme._226F8F
import com.example.proff.feature_app.presentation.ui.theme._81C1CC
import com.example.proff.feature_app.presentation.ui.theme._9CE9EE
import com.example.proff.feature_app.presentation.ui.theme.montserrat50012_A5A3B0
import com.example.proff.feature_app.presentation.ui.theme.montserrat60014Bold_1D1617
import com.example.proff.feature_app.presentation.ui.theme.montserrat60016Bold_1D1617
import org.koin.androidx.compose.koinViewModel

@Composable
fun ActivityTrackerScreen(
    navController: NavController,
    viewModel: ActivityTrackerViewModel = koinViewModel()
) {

    val state = viewModel.state.value
    val activityList = listOf(
        listOf(
            "https://nnctezenkkdwflrmazcg.supabase.co/storage/v1/object/public/toWork//glass%201.png",
            "8Л",
            "Воды"
        ),
        listOf(
            "https://nnctezenkkdwflrmazcg.supabase.co/storage/v1/object/public/toWork//boots%201.png",
            "2400",
            "Шагов"
        ),
    )

    if (state.exception.isNotEmpty()){
        CustomAlertDialog(state.exception) {
            viewModel.onEvent(ActivityTrackerEvent.ResetException)
        }
    }


    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(start = 30.dp, end = 30.dp, bottom = (LocalConfiguration.current.screenHeightDp / 20).dp)
    ) {
        CustomTopAppBar(
            title = "Трекер активности"
        ) { navController.popBackStack() }

        Spacer(Modifier.height(30.dp))

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(22.dp))
                .background(Brush.linearGradient(listOf(_226F8F, _9CE9EE)), RoundedCornerShape(22.dp), 0.2f),
            colors = CardDefaults.cardColors(Color.Transparent),
            shape = RoundedCornerShape(22.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Сегодняшняя цель",
                        style = montserrat60014Bold_1D1617
                    )
                    Spacer(Modifier.weight(1f))
                    Box(Modifier.size(24.dp).clip(RoundedCornerShape(8.dp)).background(Brush.linearGradient(
                        listOf(_81C1CC, _226F8F)
                    )), contentAlignment = Alignment.Center){
                        Icon(
                            imageVector = Icons.Default.Add,
                            contentDescription = null,
                            tint = Color.White,
                            modifier = Modifier
                                .size(14.dp)
                        )
                    }
                }
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    activityList.forEach {
                        AnimatedVisibility(
                            visible = true,
                            enter = fadeIn(tween(1000))
                        ) {
                            CustomCurrentPurpose(
                                image = it[0],
                                title = it[1],
                                description = it[2]
                            )
                            Spacer(Modifier.width(15.dp))
                        }
                    }

                }
            }
        }
        Spacer(Modifier.height(30.dp))

        LazyColumn(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            item {
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Прогресс активности",
                        style = montserrat60016Bold_1D1617
                    )
                    Spacer(Modifier.weight(1f))
                    CustomBlueButton(text = "Неделя") { }
                }
                Spacer(Modifier.height(15.dp))
                Card(
                    Modifier
                        .fillMaxWidth()
                        .shadow(10.dp, RoundedCornerShape(20.dp), spotColor = _1D161712),
                    colors = CardDefaults.cardColors(Color.White),
                    shape = RoundedCornerShape(20.dp)
                ) {
                    androidx.compose.animation.AnimatedVisibility(
                        visible = state.heartRate.isNotEmpty(),
                        enter = fadeIn(tween(500)),
                        modifier = Modifier
                            .padding(20.dp)
                    ) {
                        CustomActivityBarChart(
                            list = state.heartRate,
                            barChartColor = _9CE9EE,
                            modifier = Modifier
                                .fillMaxWidth()
                        )
                    }
                }
                Spacer(Modifier.height(30.dp))
            }

            item {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth(),
                ) {
                    Text(
                        "Последняя активность",
                        style = montserrat60016Bold_1D1617
                    )
                    Spacer(Modifier.weight(1f))
                    Text(
                        text = "Больше",
                        style = montserrat50012_A5A3B0
                    )
                }
                Spacer(Modifier.height(20.dp))
            }

            items(state.lastActivity){
                CustomLAstActivityCard(
                    title = it.title,
                    description = it.description,
                    modifier = Modifier
                        .fillMaxWidth()
                )
                Spacer(Modifier.height(15.dp))
            }
        }
    }

    CustomIndicator(state.showIndicator)
}