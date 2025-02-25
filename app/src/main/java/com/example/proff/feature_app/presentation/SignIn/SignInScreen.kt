package com.example.proff.feature_app.presentation.SignIn

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
import com.example.proff.Route
import com.example.proff.feature_app.presentation.common.CustomAlertDialog
import com.example.proff.feature_app.presentation.common.CustomBlueButton
import com.example.proff.feature_app.presentation.common.CustomIndicator
import com.example.proff.feature_app.presentation.common.CustomTextField
import com.example.proff.feature_app.presentation.ui.theme.montserrat40016_1D1617
import com.example.proff.feature_app.presentation.ui.theme.montserrat50012_ADA4A5
import com.example.proff.feature_app.presentation.ui.theme.montserrat70020Bold_1D1617
import org.koin.androidx.compose.koinViewModel

@Composable
fun SignInScreen(
    navController: NavController,
    viewModel: SignInViewModel = koinViewModel()
) {

    val state = viewModel.state.value
    val singInList = listOf(
        listOf(
            ImageVector.vectorResource(R.drawable.message_icon),
            state.email,
            {it: String -> viewModel.onEvent(SignInEvent.EmailEnter(it))} as (String) -> Unit,
            state.passwordState,
            {it: Boolean -> viewModel.onEvent(SignInEvent.PasswordStateChange(it))} as (Boolean) -> Unit,
            "Почта",
            false
        ),
        listOf(
            ImageVector.vectorResource(R.drawable.lock_icon),
            state.password,
            {it: String -> viewModel.onEvent(SignInEvent.PasswordEnter(it))} as (String) -> Unit,
            state.passwordState,
            {it: Boolean -> viewModel.onEvent(SignInEvent.PasswordStateChange(it))} as (Boolean) -> Unit,
            "Пароль",
            true
        )
    )

    LaunchedEffect(key1 = !state.isComplete) {
        if (state.isComplete){
            navController.navigate(Route.HomeScreen.route){
                popUpTo(Route.SignInScreen.route){
                    inclusive = true
                }
            }
        }
    }

    CustomIndicator(state.showIndicator)

    if (state.exception.isNotEmpty()){
        CustomAlertDialog(state.exception) {
            viewModel.onEvent(SignInEvent.ResetException)
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(start = 30.dp, end = 30.dp, top = (LocalConfiguration.current.screenHeightDp / 20).dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Привет,",
            style = montserrat40016_1D1617
        )
        Spacer(Modifier.height(5.dp))
        Text(
            text = "Добро пожаловать",
            style = montserrat70020Bold_1D1617
        )
        Spacer(Modifier.height(30.dp))

        singInList.forEach{data ->
            CustomTextField(
                leadingIcon = data[0] as ImageVector,
                value = data[1] as String,
                onValueChange = data[2] as (String) -> Unit,
                passwordState = data[3] as Boolean,
                onPasswordStateChange = data[4] as (Boolean) -> Unit,
                title = data[5] as String,
                tag = data[5] as String,
                modifier = Modifier
                    .fillMaxWidth()
            )
            Spacer(Modifier.height(15.dp))
        }

        Text(
            text = "Забыл пароль?",
            style = montserrat50012_ADA4A5
        )

        Spacer(Modifier.weight(1f))

        CustomBlueButton(
            text = "Войти",
            modifier = Modifier
                .fillMaxWidth(),
            isSignInButton = true,
            enabled = !state.showIndicator
        ) {
            viewModel.onEvent(SignInEvent.SignIn)
        }
    }
}