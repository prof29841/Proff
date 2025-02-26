package com.example.proff.feature_app.presentation.ChoosingGoal

import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerDefaults
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.proff.feature_app.presentation.Route
import com.example.proff.feature_app.presentation.common.CustomAlertDialog
import com.example.proff.feature_app.presentation.common.CustomBlueButton
import com.example.proff.feature_app.presentation.common.CustomIndicator
import com.example.proff.feature_app.presentation.ui.theme._226F8F
import com.example.proff.feature_app.presentation.ui.theme._81C1CC
import com.example.proff.feature_app.presentation.ui.theme._9CE9EE
import com.example.proff.feature_app.presentation.ui.theme.montserrat40012White
import com.example.proff.feature_app.presentation.ui.theme.montserrat40012_7B6F72
import com.example.proff.feature_app.presentation.ui.theme.montserrat60014White
import com.example.proff.feature_app.presentation.ui.theme.montserrat70020Bold_1D1617
import org.koin.androidx.compose.koinViewModel

@Composable
fun ChoosingGoalScreen(
    navController: NavController,
    viewModel: ChoosingGoalViewModel = koinViewModel()
) {

    val state = viewModel.state.value
    val pagerState = rememberPagerState { state.list.size }

    LaunchedEffect(key1 = !state.isComplete) {
        if (state.isComplete) {
            navController.navigate(Route.SuccessRegistrationScreen.route) {
                popUpTo(Route.ChoosingGoalScreen.route) {
                    inclusive = true
                }
            }
        }
    }

    if (state.exception.isNotEmpty()) {
        CustomAlertDialog(state.exception) {
            viewModel.onEvent(ChoosingGoalEvent.ResetException)
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(vertical = (LocalConfiguration.current.screenHeightDp / 20).dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Какова ваша цель?",
            style = montserrat70020Bold_1D1617
        )
        Spacer(Modifier.height(5.dp))
        Text(
            text = "Это поможет нам подобрать для вас лучшую программу.",
            style = montserrat40012_7B6F72
        )

        Spacer(Modifier.weight(1f))

        HorizontalPager(
            state = pagerState,
            modifier = Modifier
                .fillMaxWidth(),
            flingBehavior = PagerDefaults.flingBehavior(
                pagerState, snapAnimationSpec = tween(700, easing = LinearOutSlowInEasing)
            )
        ) { page ->
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(Modifier.weight(1f))
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Box(
                        Modifier
                            .width(30.dp)
                            .height((LocalConfiguration.current.screenHeightDp / 2.5).dp)
                            .clip(
                                RoundedCornerShape(topEnd = 22.dp, bottomEnd = 22.dp)
                            )
                            .background(
                                Brush.linearGradient(listOf(_226F8F, _9CE9EE)),
                                RoundedCornerShape(topEnd = 22.dp, bottomEnd = 22.dp),
                                0.3f
                            )
                    )
                    Spacer(Modifier.weight(1f))
                    Card(
                        modifier = Modifier
                            .fillMaxWidth(0.7f)
                            .fillMaxHeight(0.7f)
                            .clip(RoundedCornerShape(22.dp))
                            .background(
                                Brush.linearGradient(listOf(_81C1CC, _226F8F)),
                                RoundedCornerShape(22.dp)
                            ),
                        shape = RoundedCornerShape(22.dp),
                        colors = CardDefaults.cardColors(Color.Transparent),
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(30.dp),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.SpaceBetween
                        ) {
                            Image(
                                painter = painterResource(state.list[page].image),
                                contentDescription = null,
                                modifier = Modifier
                                    .fillMaxWidth(),
                                contentScale = ContentScale.Crop
                            )
                            Spacer(Modifier.height(25.dp))
                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Text(
                                    text = state.list[page].title,
                                    style = montserrat60014White
                                )
                                Box(Modifier.width(50.dp).height(1.dp).background(Color.White))
                                Spacer(Modifier.height(20.dp))
                                Text(
                                    text = state.list[page].description,
                                    style = montserrat40012White,
                                    modifier = Modifier
                                        .fillMaxWidth()
                                )
                            }
                        }
                    }
                    Spacer(Modifier.weight(1f))
                    Box(
                        Modifier
                            .width(30.dp)
                            .height((LocalConfiguration.current.screenHeightDp / 2.5).dp)
                            .clip(
                                RoundedCornerShape(topStart = 22.dp, bottomStart = 22.dp)
                            )
                            .background(
                                Brush.linearGradient(listOf(_226F8F, _9CE9EE)),
                                RoundedCornerShape(topStart = 22.dp, bottomStart = 22.dp),
                                0.3f
                            )
                    )
                }

                Spacer(Modifier.weight(1f))
                CustomBlueButton(
                    text = "Подтвердить",
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 30.dp)
                ) { viewModel.onEvent(ChoosingGoalEvent.ChooseGoal(state.list[page])) }
            }
        }

        Spacer(Modifier.weight(1f))
    }

    CustomIndicator(state.showIndicator)
}