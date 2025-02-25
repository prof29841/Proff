package com.example.proff.feature_app.presentation.SignUp

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
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
import com.example.proff.feature_app.presentation.common.CustomGoogleButton
import com.example.proff.feature_app.presentation.common.CustomHorizontalDivider
import com.example.proff.feature_app.presentation.common.CustomIndicator
import com.example.proff.feature_app.presentation.common.CustomTextButton
import com.example.proff.feature_app.presentation.common.CustomTextField
import com.example.proff.feature_app.presentation.ui.theme._226F8F
import com.example.proff.feature_app.presentation.ui.theme._ADA4A5
import com.example.proff.feature_app.presentation.ui.theme.montserrat40010_ADA4A5
import com.example.proff.feature_app.presentation.ui.theme.montserrat40016_1D1617
import com.example.proff.feature_app.presentation.ui.theme.montserrat70020Bold_1D1617
import org.koin.androidx.compose.koinViewModel

@Composable
fun SignUpScreen(
    navController: NavController,
    viewModel: SignUpViewModel = koinViewModel()
) {

    val state = viewModel.state.value
    val signUpList = listOf(
        listOf(
            ImageVector.vectorResource(R.drawable.profile_icon),
            state.fio,
            { it: String -> viewModel.onEvent(SignUpEvent.FioEnter(it)) } as (String) -> Unit,
            state.passwordState,
            { it: Boolean -> viewModel.onEvent(SignUpEvent.PasswordStateChange(it)) } as (Boolean) -> Unit,
            "ФИО",
            false
        ),
        listOf(
            ImageVector.vectorResource(R.drawable.phone_icon),
            state.phone,
            { it: String -> viewModel.onEvent(SignUpEvent.PhoneEnter(it)) } as (String) -> Unit,
            state.passwordState,
            { it: Boolean -> viewModel.onEvent(SignUpEvent.PasswordStateChange(it)) } as (Boolean) -> Unit,
            "Номер телефона",
            false
        ),
        listOf(
            ImageVector.vectorResource(R.drawable.message_icon),
            state.email,
            { it: String -> viewModel.onEvent(SignUpEvent.EmailEnter(it)) } as (String) -> Unit,
            state.passwordState,
            { it: Boolean -> viewModel.onEvent(SignUpEvent.PasswordStateChange(it)) } as (Boolean) -> Unit,
            "Почта",
            false
        ),
        listOf(
            ImageVector.vectorResource(R.drawable.lock_icon),
            state.password,
            { it: String -> viewModel.onEvent(SignUpEvent.PasswordEnter(it)) } as (String) -> Unit,
            state.passwordState,
            { it: Boolean -> viewModel.onEvent(SignUpEvent.PasswordStateChange(it)) } as (Boolean) -> Unit,
            "Пароль",
            true
        ),
    )

    LaunchedEffect(key1 = !state.isComplete) {
        if (state.isComplete) {
            navController.navigate(Route.CreatingProfileScreen.route) {
                popUpTo(Route.SignUpScreen.route) {
                    inclusive = true
                }
            }
        }
    }

    if (state.exception.isNotEmpty()) {
        CustomAlertDialog(state.exception) {
            viewModel.onEvent(SignUpEvent.ResetException)
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(
                horizontal = 30.dp,
                vertical = (LocalConfiguration.current.screenHeightDp / 20).dp
            ),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Привет,",
            style = montserrat40016_1D1617
        )
        Spacer(Modifier.height(5.dp))
        Text(
            text = "Создай аккаунт",
            style = montserrat70020Bold_1D1617
        )
        Spacer(Modifier.height(30.dp))

        signUpList.forEach {
            CustomTextField(
                leadingIcon = it[0] as ImageVector,
                value = it[1] as String,
                onValueChange = it[2] as (String) -> Unit,
                passwordState = it[3] as Boolean,
                onPasswordStateChange = it[4] as (Boolean) -> Unit,
                title = it[5] as String,
                isPassword = it[6] as Boolean,
                tag = it[5] as String,
                modifier = Modifier
                    .fillMaxWidth(),
                enabled = !state.showIndicator
            )
            Spacer(Modifier.height(15.dp))
        }

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Checkbox(
                checked = state.checkboxState,
                onCheckedChange = { viewModel.onEvent(SignUpEvent.CheckboxStateChange(it)) },
                modifier = Modifier
                    .size(16.dp)
                    .clip(RoundedCornerShape(3.dp))
                    .border(1.dp, _ADA4A5, RoundedCornerShape(3.dp))
                    .size(16.dp),
                enabled = !state.showIndicator,
                colors = CheckboxDefaults.colors(
                    checkedColor = _226F8F,
                    uncheckedColor = Color.White,
                    checkmarkColor = Color.White,

                )
            )
            Spacer(Modifier.width(10.dp))
            TextButton(
                onClick = { viewModel.onEvent(SignUpEvent.CheckboxStateChange(!state.checkboxState)) },
                colors = ButtonDefaults.textButtonColors(Color.Transparent),
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Text(
                    text = "Продолжая, вы принимаете нашу Политику конфиденциальности и Условия использования.",
                    style = montserrat40010_ADA4A5
                )
            }
        }

        Spacer(Modifier.weight(1f))

        CustomBlueButton(
            text = "Зарегистрироваться",
            modifier = Modifier
                .fillMaxWidth(),
            enabled = !state.showIndicator
        ) { viewModel.onEvent(SignUpEvent.SignUp) }
        Spacer(Modifier.height(20.dp))
        CustomHorizontalDivider()
        Spacer(Modifier.height(25.dp))
        CustomGoogleButton { }
        Spacer(Modifier.height(25.dp))
        CustomTextButton(
            firstText = "Имеете уже аккаунт? ",
            secondText = "Войти",
            modifier = Modifier
                .fillMaxWidth(),
            enabled = !state.showIndicator
        ) {
            navController.navigate(Route.SignInScreen.route) {
                popUpTo(Route.SignUpScreen.route) {
                    inclusive = true
                }
            }
        }
    }
    CustomIndicator(state.showIndicator)
}