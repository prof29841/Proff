package com.example.proff.feature_app.presentation.WorkoutSchedule

import androidx.compose.animation.AnimatedVisibility
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.Add
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
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.proff.feature_app.presentation.Route
import com.example.proff.feature_app.presentation.common.CustomAlertDialog
import com.example.proff.feature_app.presentation.common.CustomIndicator
import com.example.proff.feature_app.presentation.common.CustomTopAppBar
import com.example.proff.feature_app.presentation.ui.theme._226F8F
import com.example.proff.feature_app.presentation.ui.theme._9CE9EE
import com.example.proff.feature_app.presentation.ui.theme._A5A3B0
import com.example.proff.feature_app.presentation.ui.theme._F7F8F8
import com.example.proff.feature_app.presentation.ui.theme.montserrat40012_7B6F72
import com.example.proff.feature_app.presentation.ui.theme.montserrat40012_B6B4C2
import com.example.proff.feature_app.presentation.ui.theme.montserrat40014_A5A3B0
import com.example.proff.feature_app.presentation.ui.theme.montserrat50014_7B6F72
import org.koin.androidx.compose.koinViewModel
import java.time.LocalDate
import java.time.LocalDateTime

@Composable
fun WorkoutScheduleScreen(
    navController: NavController,
    viewModel: WorkoutScheduleViewModel = koinViewModel()
) {

    val state = viewModel.state.value
    if (state.exception.isNotEmpty()){
        CustomAlertDialog(state.exception) {
            viewModel.onEvent(WorkoutScheduleEvent.ResetException)
        }
    }


    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(horizontal = 30.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CustomTopAppBar(
            title = "Расписание тренировок",
        ) { navController.popBackStack() }

        Spacer(Modifier.height(30.dp))

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.AutoMirrored.Default.KeyboardArrowLeft,
                contentDescription = null,
                tint = _A5A3B0
            )
            Text(
                text = state.currentMonth + " " + state.currentData,
                style = montserrat40014_A5A3B0
            )
            Icon(
                imageVector = Icons.AutoMirrored.Default.KeyboardArrowRight,
                contentDescription = null,
                tint = _A5A3B0
            )
        }
        Spacer(Modifier.height(15.dp))

        AnimatedVisibility(
            visible = state.currentMonth.isNotEmpty() && state.currentData.isNotEmpty() && state.clock.isNotEmpty()
        ) {
            LazyRow(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                items(state.daysCount){day ->
                    Card(
                        modifier = Modifier
                            .background(
                                brush = if (day == state.currentData.toInt()) {
                                    Brush.linearGradient(listOf(_226F8F, _9CE9EE))
                                }else{
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
                                text = LocalDate.now().dayOfWeek.name[0].toString() +LocalDate.now().dayOfWeek.name[1].toString() +LocalDate.now().dayOfWeek.name[2].toString(),
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
        }

        Spacer(Modifier.height(15.dp))

        LazyColumn(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.Start
        ) {
            items(24){hour ->
                Row {
                    Text(
                        text = if ((hour+1) < 10) {
                            "0$hour:00"
                        }else{
                            "$hour:00"
                        },
                        style = montserrat40012_B6B4C2
                    )

                    androidx.compose.animation.AnimatedVisibility(
                        visible = state.workoutSchedule.isNotEmpty()
                    ) {
                        state.workoutSchedule.forEach { schedule ->
                            if (LocalDateTime.parse(schedule.time).hour == hour+1){
                                Card(
                                    colors = CardDefaults.cardColors(Color.Transparent),
                                    modifier = Modifier
                                        .clip(RoundedCornerShape(50.dp))
                                        .background(Brush.linearGradient(listOf(_226F8F, _9CE9EE)), RoundedCornerShape(50.dp), 0.8f),
                                    shape = RoundedCornerShape(50.dp)
                                ) {
                                    Text(
                                        text = state.workoutSchedule[hour].title,

                                        )
                                }
                            }
                        }
                    }
                }
                Spacer(Modifier.height(10.dp))
                Box(Modifier.fillMaxWidth().height(1.dp).background(_F7F8F8))
                Spacer(Modifier.height(10.dp))
            }
        }
    }

    Box(Modifier.fillMaxSize().padding(end = 30.dp, bottom = 40.dp), contentAlignment = Alignment.BottomEnd){
        FloatingActionButton(
            onClick = {navController.navigate(Route.AddWorkoutScheduleScreen.route)},
            modifier = Modifier
                .clip(CircleShape)
                .background(Brush.linearGradient(listOf(_226F8F, _9CE9EE)), CircleShape),
            containerColor = Color.Transparent,
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

    CustomIndicator(state.showIndicator)
}