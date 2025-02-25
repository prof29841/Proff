package com.example.proff.feature_app.presentation.CreatingProfile

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.proff.R
import com.example.proff.Route
import com.example.proff.feature_app.presentation.common.CustomAlertDialog
import com.example.proff.feature_app.presentation.common.CustomBlueButton
import com.example.proff.feature_app.presentation.common.CustomIndicator
import com.example.proff.feature_app.presentation.common.CustomTextField
import com.example.proff.feature_app.presentation.ui.theme._226F8F
import com.example.proff.feature_app.presentation.ui.theme._9CE9EE
import com.example.proff.feature_app.presentation.ui.theme.montserrat40012_7B6F72
import com.example.proff.feature_app.presentation.ui.theme.montserrat50012White
import com.example.proff.feature_app.presentation.ui.theme.montserrat70020Bold_1D1617
import org.koin.androidx.compose.koinViewModel

@Composable
fun CreatingProfileScreen(
    navController: NavController,
    viewModel: CreatingProfileViewModel = koinViewModel()
) {

    val state = viewModel.state.value
    var creatingProfileList = listOf(
        listOf(
            ImageVector.vectorResource(R.drawable.users_icon),
            state.gender,
            { it: String -> viewModel.onEvent(CreatingProfileEvent.GenderEnter(it)) } as (String) -> Unit,
            "Ваш пол",
            true,
            false,
            false,
        ),
        listOf(
            ImageVector.vectorResource(R.drawable.calendar_icon),
            state.birthdayData,
            { it: String -> viewModel.onEvent(CreatingProfileEvent.BirthdayDataEnter(it)) } as (String) -> Unit,
            "Дата рождения",
            false,
            false,
            false,
        ),
        listOf(
            ImageVector.vectorResource(R.drawable.weigh_scale_icon),
            state.weight,
            { it: String -> viewModel.onEvent(CreatingProfileEvent.WeightEnter(it)) } as (String) -> Unit,
            "Ваш вес",
            false,
            true,
            false
        ),
        listOf(
            ImageVector.vectorResource(R.drawable.height_icon),
            state.height,
            { it: String -> viewModel.onEvent(CreatingProfileEvent.HeightEnter(it)) } as (String) -> Unit,
            "Ваш рост",
            false,
            false,
            true
        ),
    )

    LaunchedEffect(key1 = !state.isComplete) {
        if (state.isComplete) {
            navController.navigate(Route.ChoosingGoalScreen.route) {
                popUpTo(Route.CreatingProfileScreen.route) {
                    inclusive = true
                }
            }
        }
    }

    if (state.exception.isNotEmpty()) {
        CustomAlertDialog(state.exception) {
            viewModel.onEvent(CreatingProfileEvent.ResetException)
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.8f),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            item {
                Image(
                    painter = painterResource(R.drawable.creating_profile_image),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 30.dp),
                    contentScale = ContentScale.Crop
                )
                Spacer(Modifier.height(25.dp))
                Text(
                    text = "Давайте создадим\n" +
                            "ваш профиль",
                    style = montserrat70020Bold_1D1617,
                    modifier = Modifier
                        .padding(horizontal = 30.dp)
                )
                Spacer(Modifier.height(7.dp))
                Text(
                    text = "Это поможет нам узнать о вас больше!",
                    style = montserrat40012_7B6F72,
                    modifier = Modifier
                        .padding(horizontal = 30.dp)
                )
                Spacer(Modifier.height(20.dp))
            }

            items(creatingProfileList) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 30.dp, end = 50.dp)
                ) {
                    CustomTextField(
                        trailingIcon = if (creatingProfileList.indexOf(it) == 0) Icons.Default.KeyboardArrowDown else null,
                        leadingIcon = it[0] as ImageVector,
                        value = it[1] as String,
                        onValueChange = it[2] as (String) -> Unit,
                        passwordState = false,
                        onPasswordStateChange = {},
                        isPassword = it[4] as Boolean,
                        title = it[3] as String,
                        enabled = !state.showIndicator,
                        modifier = Modifier
                            .weight(1f)
                    )
                    if (creatingProfileList.indexOf(it) == 2 || creatingProfileList.indexOf(it) == 3) {
                        Spacer(Modifier.width(15.dp))
                        Box(
                            Modifier
                                .clip(CircleShape)
                                .background(
                                    Brush.linearGradient(listOf(_226F8F, _9CE9EE)),
                                    CircleShape
                                ),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = if (creatingProfileList.indexOf(it) == 2) "КГ" else "СМ",
                                style = montserrat50012White,
                                modifier = Modifier
                                    .padding(15.dp)
                            )
                        }
                    }
                }
                Spacer(Modifier.height(15.dp))
            }
        }
        Spacer(Modifier.weight(1f))
        CustomBlueButton(
            text = "Далее",
            isNextButton = true,
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    bottom = (LocalConfiguration.current.screenHeightDp / 20).dp,
                    start = 40.dp,
                    end = 40.dp
                )
        ) { viewModel.onEvent(CreatingProfileEvent.CreateProfile) }
    }
    CustomIndicator(state.showIndicator)
}