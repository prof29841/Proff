package com.example.proff.feature_app.presentation.SleepTracker

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.foundation.Image
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
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.proff.R
import com.example.proff.feature_app.presentation.Route
import com.example.proff.feature_app.presentation.common.CustomAlertDialog
import com.example.proff.feature_app.presentation.common.CustomBarChart
import com.example.proff.feature_app.presentation.common.CustomIndicator
import com.example.proff.feature_app.presentation.common.CustomLightBlueCard
import com.example.proff.feature_app.presentation.common.CustomSwitch
import com.example.proff.feature_app.presentation.common.CustomTopAppBar
import com.example.proff.feature_app.presentation.ui.theme._1D161712
import com.example.proff.feature_app.presentation.ui.theme._226F8F
import com.example.proff.feature_app.presentation.ui.theme._81C1CC
import com.example.proff.feature_app.presentation.ui.theme._9CE9EE
import com.example.proff.feature_app.presentation.ui.theme._A5A3B0
import com.example.proff.feature_app.presentation.ui.theme._B6B4C2
import com.example.proff.feature_app.presentation.ui.theme.montserrat40010_9CE9EE
import com.example.proff.feature_app.presentation.ui.theme.montserrat40012_B6B4C2
import com.example.proff.feature_app.presentation.ui.theme.montserrat40014_B6B4C2
import com.example.proff.feature_app.presentation.ui.theme.montserrat50014White
import com.example.proff.feature_app.presentation.ui.theme.montserrat50014_1D1617
import com.example.proff.feature_app.presentation.ui.theme.montserrat60016Bold_1D1617
import org.koin.androidx.compose.koinViewModel

@Composable
fun SleepTrackerScreen(
    navController: NavController,
    viewModel: SleepTrackerViewModel = koinViewModel()
) {

    val state = viewModel.state.value

    if (state.exception.isNotEmpty()) {
        CustomAlertDialog(state.exception) {
            viewModel.onEvent(SleepTrackerEvent.ResetException)
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
            ),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CustomTopAppBar(
            title = "Трекер сна"
        ) { navController.popBackStack() }
        Spacer(Modifier.height(40.dp))

        AnimatedVisibility(
            visible = state.heartRate.isNotEmpty(),
            enter = fadeIn(tween(500))
        ) {
            CustomBarChart(
                list = state.heartRate,
                barChartColor = _9CE9EE,
                linesColor = _A5A3B0,
                height = 170.dp,
                modifier = Modifier
                    .fillMaxWidth(),
                textColor = _B6B4C2
            )
        }

        Spacer(Modifier.height(15.dp))
        Card(
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier
                .shadow(10.dp, RoundedCornerShape(8.dp), spotColor = _1D161712),
            colors = CardDefaults.cardColors(Color.White)
        ) {
            Text(
                text = "Увеличено на 43% ",
                style = montserrat40010_9CE9EE,
                modifier = Modifier
                    .padding(10.dp)
            )
        }
        Spacer(Modifier.height(15.dp))

        LazyColumn(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            item {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(
                            Brush.linearGradient(listOf(_81C1CC, _226F8F)),
                            RoundedCornerShape(22.dp)
                        ),
                    shape = RoundedCornerShape(22.dp),
                    colors = CardDefaults.cardColors(Color.Transparent),
                    onClick = { navController.navigate(Route.SleepScheduleScreen.route) }
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                    ) {
                        Column(
                            modifier = Modifier
                                .padding(top = 20.dp, start = 20.dp)
                        ) {
                            Text(
                                text = "Последний сон",
                                style = montserrat50014White
                            )
                            Spacer(Modifier.height(5.dp))
                            Text(
                                text = "8ч 20м",
                                style = montserrat50014White
                            )
                        }
                        AsyncImage(
                            model = "https://nnctezenkkdwflrmazcg.supabase.co/storage/v1/object/public/toWork//Sleep-Graph.png",
                            contentDescription = null,
                            modifier = Modifier
                                .fillMaxWidth(),
                            contentScale = ContentScale.Crop
                        )
                    }
                }
                Spacer(Modifier.height(30.dp))

                CustomLightBlueCard(
                    text = "Трафик сна",
                    btnText = "Проверить",
                    btnModifier = Modifier
                        .height(30.dp)
                ) { }
                Spacer(Modifier.height(30.dp))
                Text(
                    text = "Расписание на сегодня",
                    style = montserrat60016Bold_1D1617,
                    textAlign = TextAlign.Left,
                    modifier = Modifier
                        .fillMaxWidth()
                )
                Spacer(Modifier.height(15.dp))
            }

            items(state.sleepSchedule) { sleep ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .shadow(10.dp, RoundedCornerShape(20.dp), spotColor = _1D161712),
                    colors = CardDefaults.cardColors(Color.White),
                    shape = RoundedCornerShape(20.dp),
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .padding(20.dp)
                    ) {
                        Image(
                            painter = painterResource(R.drawable.sleep_icon),
                            contentDescription = null,
                            modifier = Modifier
                                .size(30.dp),
                            contentScale = ContentScale.Fit
                        )
                        Spacer(Modifier.width(15.dp))
                        Column {
                            Row(
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text(
                                    text = sleep.title,
                                    style = montserrat50014_1D1617
                                )
                                Text(
                                    text = sleep.sleepTime,
                                    style = montserrat40012_B6B4C2
                                )
                            }
                            Spacer(Modifier.height(5.dp))
                            Text(
                                text = sleep.sleepEnd,
                                style = montserrat40014_B6B4C2
                            )
                        }
                        Spacer(Modifier.weight(1f))
                        Column(
                            horizontalAlignment = Alignment.End
                        ) {
                            Icon(
                                imageVector = Icons.Default.MoreVert,
                                tint = _A5A3B0,
                                contentDescription = null
                            )
                            Spacer(Modifier.height(20.dp))
                            CustomSwitch(
                                state = sleep.enabled
                            ) { viewModel.onEvent(SleepTrackerEvent.ChangeSleepTrackerState(sleep)) }
                        }
                    }
                }
            }
        }
    }

    CustomIndicator(state.showIndicator)
}