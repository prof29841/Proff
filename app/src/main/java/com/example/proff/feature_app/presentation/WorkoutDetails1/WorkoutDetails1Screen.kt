package com.example.proff.feature_app.presentation.WorkoutDetails1

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.proff.R
import com.example.proff.feature_app.domain.model.AllWorkoutDetails
import com.example.proff.feature_app.presentation.Route
import com.example.proff.feature_app.presentation.common.CustomAlertDialog
import com.example.proff.feature_app.presentation.common.CustomBlueButton
import com.example.proff.feature_app.presentation.common.CustomIndicator
import com.example.proff.feature_app.presentation.common.CustomTopAppBar
import com.example.proff.feature_app.presentation.ui.theme._1D1617
import com.example.proff.feature_app.presentation.ui.theme._1D161712
import com.example.proff.feature_app.presentation.ui.theme._226F8F
import com.example.proff.feature_app.presentation.ui.theme._81C1CC
import com.example.proff.feature_app.presentation.ui.theme._9CE9EE
import com.example.proff.feature_app.presentation.ui.theme._F7F8F8
import com.example.proff.feature_app.presentation.ui.theme.montserrat40010_226F8F
import com.example.proff.feature_app.presentation.ui.theme.montserrat40012Black
import com.example.proff.feature_app.presentation.ui.theme.montserrat40012_226F8F
import com.example.proff.feature_app.presentation.ui.theme.montserrat40012_B6B4C2
import com.example.proff.feature_app.presentation.ui.theme.montserrat50012_A5A3B0
import com.example.proff.feature_app.presentation.ui.theme.montserrat50012_B6B4C2
import com.example.proff.feature_app.presentation.ui.theme.montserrat50014_1D1617
import com.example.proff.feature_app.presentation.ui.theme.montserrat60016Bold_1D1617
import com.example.proff.feature_app.presentation.ui.theme.montserrat70016Bold_1D1617
import org.koin.androidx.compose.koinViewModel

@Composable
fun WorkoutDetails1Screen(
    navController: NavController,
    viewModel: WorkoutDetails1ViewModel = koinViewModel()
) {

    val state = viewModel.state.value

    if (state.exception.isNotEmpty()) {
        CustomAlertDialog(state.exception) {
            viewModel.onEvent(WorkoutDetails1Event.ResetException)
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Brush.linearGradient(listOf(_81C1CC, _226F8F))),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CustomTopAppBar(
            title = "",
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 30.dp)
        ) { navController.popBackStack() }
        Spacer(Modifier.height(10.dp))
        AsyncImage(
            model = Route.WorkoutDetails1Screen.workout.image,
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .padding(horizontal = 30.dp),
            contentScale = ContentScale.Fit
        )
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White, RoundedCornerShape(topEnd = 40.dp, topStart = 40.dp))
                .padding(
                    start = 30.dp,
                    end = 30.dp,
                    bottom = (LocalConfiguration.current.screenHeightDp / 20).dp
                ),
            horizontalAlignment = Alignment.CenterHorizontally,
            userScrollEnabled = true
        ) {
            item {
                Spacer(Modifier.height(10.dp))
                Box(
                    Modifier
                        .size(50.dp, 5.dp)
                        .alpha(0.1f)
                        .background(_1D1617)
                )
                Spacer(Modifier.height(25.dp))

                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column {
                        Text(
                            text = Route.WorkoutDetails1Screen.workout.title,
                            style = montserrat70016Bold_1D1617
                        )
                        Spacer(Modifier.height(5.dp))
                        Text(
                            text = Route.WorkoutDetails1Screen.workout.description,
                            style = montserrat40012_B6B4C2
                        )
                    }
                    Spacer(Modifier.weight(1f))
                    Box(
                        Modifier
                            .size(32.dp)
                            .clip(RoundedCornerShape(8.dp))
                            .background(Color.White, RoundedCornerShape(8.dp))
                            .shadow(10.dp, RoundedCornerShape(8.dp), spotColor = _1D161712),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            imageVector = ImageVector.vectorResource(R.drawable.heart_icon),
                            contentDescription = null,
                            tint = Color.Unspecified
                        )
                    }
                }
                Spacer(Modifier.height(20.dp))

                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(16.dp))
                        .background(_9CE9EE, RoundedCornerShape(16.dp)),
                    colors = CardDefaults.cardColors(Color.Transparent),
                    shape = RoundedCornerShape(16.dp)
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .padding(15.dp)
                    ) {
                        Icon(
                            imageVector = ImageVector.vectorResource(R.drawable.calendar_icon),
                            contentDescription = null,
                            tint = Color.Unspecified
                        )
                        Spacer(Modifier.width(10.dp))
                        Text(
                            text = "Время тренировки",
                            style = montserrat40012_226F8F
                        )
                        Spacer(Modifier.weight(1f))
                        Text(
                            text = "27 мая, 09:00",
                            style = montserrat40010_226F8F
                        )
                        Spacer(Modifier.width(10.dp))
                        Icon(
                            imageVector = Icons.AutoMirrored.Default.KeyboardArrowRight,
                            contentDescription = null,
                            tint = _226F8F
                        )
                    }
                }
                Spacer(Modifier.height(15.dp))
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(16.dp))
                        .background(_9CE9EE, RoundedCornerShape(16.dp)),
                    colors = CardDefaults.cardColors(Color.Transparent),
                    shape = RoundedCornerShape(16.dp)
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .padding(15.dp)
                    ) {
                        Icon(
                            imageVector = ImageVector.vectorResource(R.drawable.height_icon),
                            contentDescription = null,
                            tint = Color.Unspecified
                        )
                        Spacer(Modifier.width(10.dp))
                        Text(
                            text = "Сложность",
                            style = montserrat40012_226F8F
                        )
                        Spacer(Modifier.weight(1f))
                        Text(
                            text = "Начинающий",
                            style = montserrat40010_226F8F
                        )
                        Spacer(Modifier.width(10.dp))
                        Icon(
                            imageVector = Icons.AutoMirrored.Default.KeyboardArrowRight,
                            contentDescription = null,
                            tint = _226F8F
                        )
                    }
                }
                Spacer(Modifier.height(30.dp))
            }

            item {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    Text(
                        text = "Вам понадобится",
                        style = montserrat60016Bold_1D1617
                    )
                    Spacer(Modifier.weight(1f))
                    Text(
                        text = "5 предметов",
                        style = montserrat50012_A5A3B0
                    )
                }
                Spacer(Modifier.height(15.dp))
            }

            item {
                LazyRow(
                    modifier = Modifier
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    items(state.items) {
                        Column {
                            Box(
                                Modifier
                                    .clip(RoundedCornerShape(12.dp))
                                    .background(_F7F8F8, RoundedCornerShape(12.dp)),
                                contentAlignment = Alignment.Center
                            ) {
                                AsyncImage(
                                    model = when (it) {
                                        1 -> {
                                            "https://nnctezenkkdwflrmazcg.supabase.co/storage/v1/object/public/avatars//dumbbells.png"
                                        }

                                        2 -> {
                                            "https://nnctezenkkdwflrmazcg.supabase.co/storage/v1/object/public/avatars//skipping_rope.png"
                                        }

                                        else -> {
                                            "https://nnctezenkkdwflrmazcg.supabase.co/storage/v1/object/public/avatars//skipping_rope.png"
                                        }
                                    },
                                    contentScale = ContentScale.Crop,
                                    contentDescription = null,
                                    modifier = Modifier
                                        .size(60.dp)
                                        .padding(30.dp)
                                )
                            }
                            Spacer(Modifier.height(10.dp))
                            Text(
                                text = state.itemsList[it],
                                style = montserrat40012Black
                            )
                        }
                        Spacer(Modifier.width(15.dp))
                    }
                }
                Spacer(Modifier.height(30.dp))
            }

            item {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    Text(
                        text = "Упражнения",
                        style = montserrat60016Bold_1D1617
                    )
                    Spacer(Modifier.weight(1f))
                    Text(
                        text = "3 подхода",
                        style = montserrat50012_A5A3B0
                    )
                }
                Spacer(Modifier.height(20.dp))
            }

            items(state.details) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable {
                            Route.WorkoutDetails2Screen.workout = AllWorkoutDetails(0, it.id, "","","")
                            navController.navigate(Route.WorkoutDetails2Screen.route)
                        }
                ) {
                    AsyncImage(
                        model = it.workoutImage,
                        contentDescription = null,
                        modifier = Modifier
                            .size(60.dp),
                        contentScale = ContentScale.Crop,
                    )
                    Spacer(Modifier.width(10.dp))
                    Column {
                        Text(
                            text = it.workoutTitle,
                            style = montserrat50014_1D1617
                        )
                        Spacer(Modifier.height(5.dp))
                        Text(
                            text = it.workoutTime,
                            style = montserrat50012_B6B4C2
                        )
                    }
                    Spacer(Modifier.weight(1f))
                    Icon(
                        imageVector = ImageVector.vectorResource(R.drawable.arrow_right_circle),
                        contentDescription = null,
                        tint = Color.Unspecified
                    )
                }
            }

            item {
                CustomBlueButton(
                    text = "Начать",
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    navController.navigate(Route.CongratulationsPageScreen.route) {
                        popUpTo(Route.WorkoutDetails1Screen.route) {
                            inclusive = true
                        }
                    }
                }
            }
        }
    }

    CustomIndicator(state.showIndicator)
}