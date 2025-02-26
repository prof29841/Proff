package com.example.proff.feature_app.presentation.AddWorkoutSchedule

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.proff.R
import com.example.proff.feature_app.presentation.common.CustomAlertDialog
import com.example.proff.feature_app.presentation.common.CustomBlueButton
import com.example.proff.feature_app.presentation.common.CustomIndicator
import com.example.proff.feature_app.presentation.common.CustomTopAppBar
import com.example.proff.feature_app.presentation.ui.theme._A5A3B0
import com.example.proff.feature_app.presentation.ui.theme._B6B4C2
import com.example.proff.feature_app.presentation.ui.theme._F7F8F8
import com.example.proff.feature_app.presentation.ui.theme.montserrat40010_A5A3B0
import com.example.proff.feature_app.presentation.ui.theme.montserrat40012_B6B4C2
import com.example.proff.feature_app.presentation.ui.theme.montserrat40014_B6B4C2
import com.example.proff.feature_app.presentation.ui.theme.montserrat50014_1D1617
import org.koin.androidx.compose.koinViewModel

@Composable
fun AddWorkoutScheduleScreen(
    navController: NavController,
    viewModel: AddWorkoutScheduleViewModel = koinViewModel()
) {

    val state = viewModel.state.value
    val detailsCardList = listOf(
        listOf(
            ImageVector.vectorResource(R.drawable.dumbbels_icon),
            "Трениовка",
            "Вверхняя часть",
            {} as () -> Unit
        ),
        listOf(
            ImageVector.vectorResource(R.drawable.height_icon),
            "Сложность",
            "Начинающй",
            {} as () -> Unit
        ),
        listOf(
            ImageVector.vectorResource(R.drawable.profile_workout_icon),
            "Пользовательские повторы",
            "",
            {} as () -> Unit
        ),
        listOf(
            ImageVector.vectorResource(R.drawable.profile_workout_icon),
            "Пользовательские веса",
            "",
            {} as () -> Unit
        ),
    )
    if (state.exception.isNotEmpty()){
        CustomAlertDialog(state.exception) {
            viewModel.onEvent(AddWorkoutScheduleEvent.ResetException)
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
        horizontalAlignment = Alignment.Start
    ) {
        CustomTopAppBar(
            title = "Добавить расписание",
        ) { navController.popBackStack() }
        Spacer(Modifier.height(30.dp))
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = ImageVector.vectorResource(R.drawable.calendar_icon),
                contentDescription = null,
                tint = Color.Unspecified
            )
            Spacer(Modifier.width(10.dp))
            Text(
                text = state.dayName[0].toString() +
                    state.dayName[1].toString() +
                    state.dayName[2].toString() +
                    "., " +
                    state.dayNumber + state.monthName + state.year,
                style = montserrat40014_B6B4C2
            )
        }
        Spacer(Modifier.height(30.dp))
        AsyncImage(
            model = "https://nnctezenkkdwflrmazcg.supabase.co/storage/v1/object/public/toWork//Time-Section.png",
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth(),
            contentScale = ContentScale.Fit
        )
        Spacer(Modifier.height(30.dp))
        Text(
            text = "Детали тренировки",
            style = montserrat50014_1D1617
        )
        Spacer(Modifier.height(10.dp))

        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.5f),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            items(detailsCardList){
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(16.dp))
                        .background(_F7F8F8, RoundedCornerShape(16.dp)),
                    colors = CardDefaults.cardColors(_F7F8F8),
                    shape = RoundedCornerShape(16.dp)
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .padding(15.dp)
                            .clickable { (it[3] as () -> Unit).invoke()  }
                    ) {
                        Icon(
                            imageVector = it[0] as ImageVector,
                            contentDescription = null,
                            tint = _B6B4C2
                        )
                        Text(
                            text = it[1] as String,
                            style = montserrat40012_B6B4C2
                        )
                        Spacer(Modifier.weight(1f))
                        Text(
                            text = it[2] as String,
                            style = montserrat40010_A5A3B0
                        )
                        Icon(
                            imageVector = Icons.AutoMirrored.Default.KeyboardArrowRight,
                            contentDescription = null,
                            tint = _A5A3B0
                        )
                    }
                }
                Spacer(Modifier.height(10.dp))
            }
        }
        Spacer(Modifier.weight(1f))

        CustomBlueButton(
            text = "Сохранить",
            modifier = Modifier
                .fillMaxWidth()
        ) { viewModel.onEvent(AddWorkoutScheduleEvent.AddWorkout) }
    }

    CustomIndicator(state.showIndicator)
}