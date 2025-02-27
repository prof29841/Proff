package com.example.proff.feature_app.presentation.AddAlarm

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.proff.R
import com.example.proff.feature_app.presentation.Route
import com.example.proff.feature_app.presentation.common.CustomAlertDialog
import com.example.proff.feature_app.presentation.common.CustomBlueButton
import com.example.proff.feature_app.presentation.common.CustomIndicator
import com.example.proff.feature_app.presentation.common.CustomSwitch
import com.example.proff.feature_app.presentation.common.CustomTopAppBar
import com.example.proff.feature_app.presentation.ui.theme._A5A3B0
import com.example.proff.feature_app.presentation.ui.theme._F7F8F8
import com.example.proff.feature_app.presentation.ui.theme.montserrat40010_A5A3B0
import com.example.proff.feature_app.presentation.ui.theme.montserrat40012_B6B4C2
import org.koin.androidx.compose.koinViewModel

@Composable
fun AddAlarmScreen(
    navController: NavController,
    viewModel: AddAlarmViewModel = koinViewModel()
) {

    val state = viewModel.state.value
    val alarmList = listOf(
        listOf(
            ImageVector.vectorResource(R.drawable.bed_icon),
            "Сон",
            state.sleep,
            false
        ),
        listOf(
            ImageVector.vectorResource(R.drawable.clock_icon),
            "Часов для сна",
            state.sleepTime,
            false
        ),
        listOf(
            ImageVector.vectorResource(R.drawable.repeat_icon),
            "Повтор",
            "Пон по Пят",
            false
        ),
        listOf(
            ImageVector.vectorResource(R.drawable.vibrate_icon),
            "Вибрировать при звуке",
            state.isVibrate,
            true
        ),
    )

    if (state.exception.isNotEmpty()){
        CustomAlertDialog(state.exception) {
            viewModel.onEvent(AddAlarmEvent.ResetException)
        }
    }

    LaunchedEffect(key1 = !state.isComplete) {
        if (state.isComplete){
            viewModel.onEvent(AddAlarmEvent.ChangeIsCompleteState)
            navController.navigate(Route.SleepScheduleScreen.route){
                popUpTo(Route.AddAlarmScreen.route){
                    inclusive = true
                }
            }
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(start = 30.dp, end = 30.dp, bottom = (LocalConfiguration.current.screenHeightDp / 20).dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CustomTopAppBar(
            title = "Добавить часы"
        ) { navController.popBackStack() }
        Spacer(Modifier.height(30.dp))

        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.6f),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            items(alarmList){
                Card(
                    modifier = Modifier
                        .fillMaxWidth(),
                    colors = CardDefaults.cardColors(_F7F8F8),
                    shape = RoundedCornerShape(16.dp)
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .padding(15.dp)
                    ) {
                        Icon(
                            imageVector = it[0] as ImageVector,
                            contentDescription = null,
                            tint = Color.Unspecified
                        )
                        Spacer(Modifier.width(10.dp))
                        Text(
                            text = it[1] as String,
                            style = montserrat40012_B6B4C2
                        )
                        Spacer(Modifier.weight(1f))
                        if (it[3] as Boolean){
                            CustomSwitch(state.isVibrate, enabled = !state.showIndicator) {
                                viewModel.onEvent(AddAlarmEvent.ChangeVibrateState(it))
                            }
                        }else{
                            Text(
                                text = it[2] as String,
                                style = montserrat40010_A5A3B0
                            )
                            Spacer(Modifier.width(5.dp))
                            Icon(
                                imageVector = Icons.AutoMirrored.Default.KeyboardArrowRight,
                                contentDescription = null,
                                tint = _A5A3B0
                            )
                        }
                    }
                }
                Spacer(Modifier.height(10.dp))
            }
        }
        Spacer(Modifier.weight(1f))
        CustomBlueButton(
            text = "Добавить",
            modifier = Modifier
                .fillMaxWidth()
        ) {
            viewModel.onEvent(AddAlarmEvent.AddAlarm)
        }
    }

    CustomIndicator(state.showIndicator)
}