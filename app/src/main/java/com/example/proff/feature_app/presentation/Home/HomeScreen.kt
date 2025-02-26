package com.example.proff.feature_app.presentation.Home

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import co.yml.charts.common.extensions.isNotNull
import com.example.proff.R
import com.example.proff.feature_app.presentation.Home.components.CustomPieChart
import com.example.proff.feature_app.presentation.Home.components.HomeBarChart
import com.example.proff.feature_app.presentation.Route
import com.example.proff.feature_app.presentation.common.CustomAlertDialog
import com.example.proff.feature_app.presentation.common.CustomBlueButton
import com.example.proff.feature_app.presentation.common.CustomBottomNavigation
import com.example.proff.feature_app.presentation.common.CustomIndicator
import com.example.proff.feature_app.presentation.common.CustomLightBlueCard
import com.example.proff.feature_app.presentation.ui.theme._1D161712
import com.example.proff.feature_app.presentation.ui.theme._226F8F
import com.example.proff.feature_app.presentation.ui.theme._81C1CC
import com.example.proff.feature_app.presentation.ui.theme._9CE9EE
import com.example.proff.feature_app.presentation.ui.theme._F7F8F8
import com.example.proff.feature_app.presentation.ui.theme.montserrat40010_B6B4C2
import com.example.proff.feature_app.presentation.ui.theme.montserrat40012White
import com.example.proff.feature_app.presentation.ui.theme.montserrat40012_A5A3B0
import com.example.proff.feature_app.presentation.ui.theme.montserrat50012_1D1617
import com.example.proff.feature_app.presentation.ui.theme.montserrat60014White
import com.example.proff.feature_app.presentation.ui.theme.montserrat60014_226F8F
import com.example.proff.feature_app.presentation.ui.theme.montserrat60016Bold_1D1617
import com.example.proff.feature_app.presentation.ui.theme.montserrat70020Bold_1D1617
import org.koin.androidx.compose.koinViewModel

@Composable
fun HomeScreen(
    navController: NavController,
    viewModel: HomeViewModel = koinViewModel()
) {

    val state = viewModel.state.value

    if (state.exception.isNotEmpty()) {
        CustomAlertDialog(state.exception) {
            viewModel.onEvent(HomeEvent.ResetException)
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(top = (LocalConfiguration.current.screenHeightDp / 20).dp)
    ) {

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 30.dp)
        ) {
            Column {
                Text(
                    text = "Добро пожаловать,",
                    style = montserrat40012_A5A3B0
                )
                Spacer(Modifier.height(5.dp))
                AnimatedVisibility(
                    visible = state.userData.isNotNull(),
                    enter = fadeIn(tween(500))
                ) {
                    Text(
                        text = state.userData!!.fio,
                        style = montserrat70020Bold_1D1617
                    )
                }
            }
            Spacer(Modifier.weight(1f))
            Box(
                Modifier
                    .size(40.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .background(_F7F8F8, RoundedCornerShape(8.dp))
                    .clickable { navController.navigate(Route.NotificationScreen.route) },
                contentAlignment = Alignment.BottomCenter
            ) {
                Icon(
                    imageVector = ImageVector.vectorResource(R.drawable.notification_icon),
                    contentDescription = null,
                    tint = Color.Unspecified
                )
            }
        }
        Spacer(Modifier.height(30.dp))

        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.8f)
                .padding(horizontal = 30.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            item {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Brush.linearGradient(listOf(_81C1CC, _226F8F)), RoundedCornerShape(22.dp)),
                    shape = RoundedCornerShape(22.dp),
                    colors = CardDefaults.cardColors(Color.Transparent),
                    onClick = {navController.navigate(Route.CategoryBreakfastScreen.route)}
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 20.dp, vertical = 25.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Column {
                            Text(
                                text = "ИМТ (индекс массы тела)",
                                style = montserrat60014White
                            )
                            Spacer(Modifier.height(5.dp))
                            Text(
                                text = "У тебя нормальный вес",
                                style = montserrat40012White
                            )
                            Spacer(Modifier.height(15.dp))
                            CustomBlueButton(
                                text = "Больше",
                            ) { navController.navigate(Route.CategoryBreakfastScreen.route) }
                        }
                        Spacer(Modifier.weight(1f))
                        CustomPieChart(
                            value = state.massBodyIndex,
                            modifier = Modifier
                                .clip(CircleShape)
                                .background(Color.Transparent, CircleShape)
                        )
                    }
                }
                Spacer(Modifier.height(30.dp))
            }

            item {
                CustomLightBlueCard(
                    text = "Сегодняшняя цель",
                    btnText = "Проверить"
                ) { navController.navigate(Route.ActivityTrackerScreen.route) }
                Spacer(Modifier.height(30.dp))
                Text(
                    text = "Статус активности",
                    style = montserrat60016Bold_1D1617,
                    textAlign = TextAlign.Left,
                    modifier = Modifier
                        .fillMaxWidth()
                )
                Spacer(Modifier.height(15.dp))
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Brush.linearGradient(listOf(_81C1CC, _226F8F)), RoundedCornerShape(20.dp), 0.2f),
                    colors = CardDefaults.cardColors(Color.Transparent),
                    shape = RoundedCornerShape(20.dp)
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(20.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = "Частота сердечных сокращений",
                            style = montserrat50012_1D1617,
                            modifier = Modifier
                                .fillMaxWidth(),
                            textAlign = TextAlign.Left
                        )
                        Spacer(Modifier.height(5.dp))
                        androidx.compose.animation.AnimatedVisibility(
                            visible = state.heartRate.isNotEmpty(),
                            enter = fadeIn(tween(500))
                        ) {
                            HomeBarChart(
                                list = state.heartRate,
                                barChartColor = _9CE9EE,
                                height = 80.dp,
                                modifier = Modifier
                                    .fillMaxWidth()
                            )
                        }
                        Spacer(Modifier.height(15.dp))
                        Text(
                            text = state.heartRate.average().toString() + " BPM",
                            style = montserrat60014_226F8F
                        )
                    }
                }
                Spacer(Modifier.height(20.dp))
            }

            item {
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                ) {
                    Card(
                        shape = RoundedCornerShape(20.dp),
                        colors = CardDefaults.cardColors(Color.White),
                        modifier = Modifier
                            .weight(1f)
                            .shadow(10.dp, RoundedCornerShape(20.dp), spotColor = _1D161712)
                    ) {
                        Row(
                            modifier = Modifier
                                .padding(20.dp)
                        )  {
                            Box(Modifier.size(20.dp, 50.dp).clip(RoundedCornerShape(30.dp)).background(
                                _F7F8F8, RoundedCornerShape(30.dp)
                            ))
                            Column{
                                Text(
                                    text = "Вода",
                                    style = montserrat50012_1D1617
                                )
                                Spacer(Modifier.height(5.dp))
                                Text(
                                    text = "4 Литра",
                                    style = montserrat60014_226F8F
                                )
                                Spacer(Modifier.height(10.dp))
                                Text(
                                    text = "В реал. времени",
                                    style = montserrat40010_B6B4C2
                                )
                            }
                        }
                    }
                    Spacer(Modifier.width(15.dp))
                    Card(
                        shape = RoundedCornerShape(20.dp),
                        colors = CardDefaults.cardColors(Color.White),
                        modifier = Modifier
                            .weight(1f)
                            .shadow(10.dp, RoundedCornerShape(20.dp), spotColor = _1D161712),
                        onClick = { navController.navigate(Route.SleepTrackerScreen.route) }
                    ) {
                        Column(
                            modifier = Modifier
                                .padding(20.dp)
                        ) {
                            Text(
                                text = "Сон",
                                style = montserrat50012_1D1617
                            )
                            Spacer(Modifier.height(5.dp))
                            Text(
                                text = "8 ч. 20 мин.",
                                style = montserrat60014_226F8F
                            )
                        }
                    }
                }
            }
        }


        Spacer(Modifier.weight(1f))
        CustomBottomNavigation(Route.HomeScreen, navController, modifier = Modifier.fillMaxWidth())
    }

    CustomIndicator(state.showIndicator)
}