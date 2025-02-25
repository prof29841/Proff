package com.example.proff

import androidx.activity.ComponentActivity
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onAllNodesWithTag
import androidx.compose.ui.test.onFirst
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import androidx.navigation.compose.rememberNavController
import com.example.proff.feature_app.domain.usecase.Auth.SignInUseCase
import com.example.proff.feature_app.domain.usecase.Auth.SignInWithGoogleUseCase
import com.example.proff.feature_app.presentation.SignIn.SignInScreen
import com.example.proff.feature_app.presentation.SignIn.SignInViewModel
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class Test {

    private lateinit var signInUseCase: SignInUseCase
    private lateinit var signInWithGoogleUseCase: SignInWithGoogleUseCase

    @get:Rule
    val rule = createAndroidComposeRule<ComponentActivity>()

    @Before
    fun initialization(){
        val repository = TestRepositoryImpl()

        signInUseCase = SignInUseCase(repository)
        signInWithGoogleUseCase = SignInWithGoogleUseCase(repository)
    }

    @Test
    fun emailValidationSuccess(){
        rule.setContent {
            SignInScreen(
                rememberNavController(),
                SignInViewModel(signInUseCase, signInWithGoogleUseCase)
            )
        }

        rule.onAllNodesWithTag("Почта").onFirst().performTextInput("qwerty@gmail.com")
        rule.onAllNodesWithTag("btn").onFirst().performClick()
    }
    @Test
    fun emailValidationFailed(){
        rule.setContent {
            SignInScreen(
                rememberNavController(),
                SignInViewModel(signInUseCase, signInWithGoogleUseCase)
            )
        }

        rule.onAllNodesWithTag("Почта").onFirst().performTextInput("qwerty")
        rule.onAllNodesWithTag("btn").onFirst().performClick()
        rule.onAllNodesWithTag("dialog").onFirst().performClick()
    }
    @Test
    fun passwordValidationSuccess(){
        rule.setContent {
            SignInScreen(
                rememberNavController(),
                SignInViewModel(signInUseCase, signInWithGoogleUseCase)
            )
        }

        rule.onAllNodesWithTag("Пароль").onFirst().performTextInput("hpHdy47DHnej")
        rule.onAllNodesWithTag("btn").onFirst().performClick()
    }
    @Test
    fun passwordValidationFailed(){
        rule.setContent {
            SignInScreen(
                rememberNavController(),
                SignInViewModel(signInUseCase, signInWithGoogleUseCase)
            )
        }

        rule.onAllNodesWithTag("Пароль").onFirst().performTextInput("hpH")
        rule.onAllNodesWithTag("btn").onFirst().performClick()
        rule.onAllNodesWithTag("dialog").onFirst().performClick()
    }

    @Test
    fun successAuthorization(){
        rule.setContent {
            SignInScreen(
                rememberNavController(),
                SignInViewModel(signInUseCase, signInWithGoogleUseCase)
            )
        }

        rule.onAllNodesWithTag("Почта").onFirst().performTextInput("qwerty@gmail.com")
        rule.onAllNodesWithTag("Пароль").onFirst().performTextInput("hpHdy47DHnej")
        rule.onAllNodesWithTag("btn").onFirst().performClick()
    }
    @Test
    fun failedAuthorization(){
        rule.setContent {
            SignInScreen(
                rememberNavController(),
                SignInViewModel(signInUseCase, signInWithGoogleUseCase)
            )
        }

        rule.onAllNodesWithTag("Почта").onFirst().performTextInput("qwer")
        rule.onAllNodesWithTag("Пароль").onFirst().performTextInput("hp")
        rule.onAllNodesWithTag("btn").onFirst().performClick()
        rule.onAllNodesWithTag("dialog").onFirst().performClick()
    }
}