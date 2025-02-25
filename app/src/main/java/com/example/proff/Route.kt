package com.example.proff

sealed class Route(val route: String) {

    data object SplashScreen : Route("SplashScreen")
    data object OnBoardScreen : Route("OnBoardScreen")

    data object SignInScreen : Route("SignInScreen")
    data object SignUpScreen : Route("SignUpScreen")
    data object CreatingProfileScreen : Route("CreatingProfileScreen")
    data object ChoosingGoalScreen : Route("ChoosingGoalScreen")
    data object SuccessRegistrationScreen : Route("SuccessRegistrationScreen")

    data object HomeScreen : Route("HomeScreen")
}