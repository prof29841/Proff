package com.example.proff.feature_app.presentation.SuccessRegistration

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.proff.R
import com.example.proff.feature_app.presentation.Route
import com.example.proff.feature_app.presentation.common.CustomAlertDialog
import com.example.proff.feature_app.presentation.common.CustomBlueButton
import com.example.proff.feature_app.presentation.common.CustomIndicator
import com.example.proff.feature_app.presentation.ui.theme.montserrat40012_7B6F72
import com.example.proff.feature_app.presentation.ui.theme.montserrat70020Bold_1D1617
import org.koin.androidx.compose.koinViewModel

@Composable
fun SuccessRegistrationScreen(
    navController: NavController,
    viewModel: SuccessRegistrationViewModel = koinViewModel()
) {

    val state = viewModel.state.value

    if (state.exception.isNotEmpty()) {
        CustomAlertDialog(state.exception) {
            viewModel.onEvent(SuccessRegistrationEvent.ResetException)
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(
                start = 30.dp,
                end = 30.dp,
                top = (LocalConfiguration.current.screenHeightDp / 9).dp,
                bottom = (LocalConfiguration.current.screenHeightDp / 20).dp
            ),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(R.drawable.success_registration_image),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp),
            contentScale = ContentScale.Crop
        )
        Spacer(Modifier.height(40.dp))
        AnimatedVisibility(
            visible = state.userFio.isNotEmpty(),
            enter = fadeIn(tween(500))
        ) {
            Text(
                text = "Добро пожаловать, \n" +
                        state.userFio,
                style = montserrat70020Bold_1D1617
            )
        }
        Spacer(Modifier.height(5.dp))
        Text(
            text = "Теперь все готово, давайте\nдостигать ваших целей\nвместе с нами.",
            style = montserrat40012_7B6F72
        )
        Spacer(Modifier.weight(1f))
        CustomBlueButton(
            text = "Перейти домой",
            modifier = Modifier
                .fillMaxWidth()
        ) {
            navController.navigate(Route.HomeScreen.route) {
                popUpTo(Route.SuccessRegistrationScreen.route) {
                    inclusive = true
                }
            }
        }
    }

    CustomIndicator(state.showIndicator)
}