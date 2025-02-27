package com.example.proff.feature_app.presentation.SleepSchedule

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.proff.R
import com.example.proff.feature_app.presentation.Route
import com.example.proff.feature_app.presentation.SleepTracker.SleepTrackerEvent
import com.example.proff.feature_app.presentation.common.CustomAlertDialog
import com.example.proff.feature_app.presentation.common.CustomBlueButton
import com.example.proff.feature_app.presentation.common.CustomIndicator
import com.example.proff.feature_app.presentation.common.CustomSwitch
import com.example.proff.feature_app.presentation.common.CustomTopAppBar
import com.example.proff.feature_app.presentation.ui.theme._1D161712
import com.example.proff.feature_app.presentation.ui.theme._226F8F
import com.example.proff.feature_app.presentation.ui.theme._9CE9EE
import com.example.proff.feature_app.presentation.ui.theme._A5A3B0
import com.example.proff.feature_app.presentation.ui.theme._F7F8F8
import com.example.proff.feature_app.presentation.ui.theme.montserrat40012_1D1617
import com.example.proff.feature_app.presentation.ui.theme.montserrat40012_7B6F72
import com.example.proff.feature_app.presentation.ui.theme.montserrat40012_B6B4C2
import com.example.proff.feature_app.presentation.ui.theme.montserrat40014_B6B4C2
import com.example.proff.feature_app.presentation.ui.theme.montserrat50010White
import com.example.proff.feature_app.presentation.ui.theme.montserrat50014_1D1617
import com.example.proff.feature_app.presentation.ui.theme.montserrat50014_226F8F
import com.example.proff.feature_app.presentation.ui.theme.montserrat50014_7B6F72
import org.koin.androidx.compose.koinViewModel
import java.time.LocalDate

@Composable
fun SleepScheduleScreen(
    navController: NavController,
    viewModel: SleepScheduleViewModel = koinViewModel()
) {

    val state = viewModel.state.value

    if (state.exception.isNotEmpty()) {
        CustomAlertDialog(state.exception) {
            viewModel.onEvent(SleepScheduleEvent.ResetException)
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
            title = "График сна"
        ) {
            navController.navigate(Route.HomeScreen.route) {
                popUpTo(Route.SleepScheduleScreen.route) {
                    inclusive = true
                }
            }
        }
        Spacer(Modifier.height(30.dp))

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    Brush.linearGradient(listOf(_226F8F, _9CE9EE)),
                    RoundedCornerShape(22.dp),
                    0.2f
                ),
            shape = RoundedCornerShape(22.dp),
            colors = CardDefaults.cardColors(Color.Transparent)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(
                    modifier = Modifier
                        .padding(20.dp)
                ) {
                    Text(
                        text = "Идеальные часы для сна",
                        style = montserrat40012_1D1617
                    )
                    Spacer(Modifier.height(5.dp))
                    Text(
                        text = "8 часов 30 минут",
                        style = montserrat50014_226F8F
                    )
                    Spacer(Modifier.height(15.dp))
                    CustomBlueButton(
                        text = "Больше",
                        modifier = Modifier
                            .height(35.dp)
                    ) { }
                }
                Spacer(Modifier.weight(1f))
                AsyncImage(
                    model = "https://nnctezenkkdwflrmazcg.supabase.co/storage/v1/object/public/toWork//Vector%20(3).png",
                    contentDescription = null,
                    modifier = Modifier
                        .size(120.dp, 100.dp),
                    contentScale = ContentScale.Crop
                )
            }
        }

        Spacer(Modifier.height(30.dp))
        LazyColumn(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            item {
                LazyRow(
                    modifier = Modifier
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    items(state.dayCount) { day ->
                        Card(
                            modifier = Modifier
                                .background(
                                    brush = if (day == state.currentDay) {
                                        Brush.linearGradient(listOf(_226F8F, _9CE9EE))
                                    } else {
                                        Brush.linearGradient(listOf(_F7F8F8, _F7F8F8))
                                    },
                                    RoundedCornerShape(10.dp)
                                ),
                            shape = RoundedCornerShape(10.dp),
                            colors = CardDefaults.cardColors(Color.Transparent)
                        ) {
                            Column(
                                modifier = Modifier
                                    .padding(horizontal = 20.dp, vertical = 15.dp),
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Text(
                                    text = LocalDate.now().dayOfWeek.name[0].toString() + LocalDate.now().dayOfWeek.name[1].toString() + LocalDate.now().dayOfWeek.name[2].toString(),
                                    style = montserrat40012_7B6F72
                                )
                                Spacer(Modifier.height(10.dp))
                                Text(
                                    text = day.toString(),
                                    style = montserrat50014_7B6F72
                                )
                            }
                        }
                        Spacer(Modifier.width(15.dp))
                    }
                }
                Spacer(Modifier.height(30.dp))
            }

            items(state.sleepSchedule){sleep ->
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
                            ) { viewModel.onEvent(SleepScheduleEvent.ChangeEnabled(sleep)) }
                        }
                    }
                }
            }

            item {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(
                            Brush.linearGradient(listOf(_226F8F, _9CE9EE)),
                            RoundedCornerShape(20.dp),
                            0.2f
                        ),
                    colors = CardDefaults.cardColors(Color.Transparent),
                    shape = RoundedCornerShape(20.dp)
                ) {
                    Column(
                        modifier = Modifier
                            .padding(20.dp)
                    ) {
                        Text(
                            text = "Сегодня вечером у тебя будет\n8 часов 10 минут.",
                            style = montserrat40012_1D1617
                        )
                        Spacer(Modifier.height(10.dp))
                        Box {
                            Box(
                                Modifier
                                    .fillMaxWidth()
                                    .height(15.dp)
                                    .clip(RoundedCornerShape(99.dp))
                                    .background(
                                        _F7F8F8, RoundedCornerShape(99.dp)
                                    )
                            )
                            Box(
                                Modifier
                                    .fillMaxWidth(0.7f)
                                    .height(15.dp)
                                    .clip(RoundedCornerShape(99.dp))
                                    .background(
                                        Brush.linearGradient(listOf(_226F8F, _9CE9EE)), RoundedCornerShape(99.dp)
                                    ),
                                contentAlignment = Alignment.Center
                            ){
                                Text(
                                    text = "96%",
                                    style = montserrat50010White
                                )
                            }
                        }

                    }
                }
            }

            item {
                Box(Modifier.fillMaxSize(), contentAlignment = Alignment.BottomEnd){
                    FloatingActionButton(
                        onClick = {navController.navigate(Route.AddAlarmScreen.route)},
                        containerColor = Color.Transparent,
                        modifier = Modifier
                            .clip(CircleShape)
                            .background(Brush.linearGradient(listOf(_226F8F, _9CE9EE)), CircleShape),
                        shape = CircleShape,
                        elevation = FloatingActionButtonDefaults.elevation(0.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Default.Add,
                            contentDescription = null,
                            tint = Color.White
                        )
                    }
                }
            }
        }
    }

    CustomIndicator(state.showIndicator)
}