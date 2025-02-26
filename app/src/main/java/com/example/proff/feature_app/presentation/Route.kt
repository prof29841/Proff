package com.example.proff.feature_app.presentation

sealed class Route(val route: String) {

    data object SplashScreen : Route("SplashScreen")
    data object OnBoardScreen : Route("OnBoardScreen")

    data object SignInScreen : Route("SignInScreen")
    data object SignUpScreen : Route("SignUpScreen")
    data object CreatingProfileScreen : Route("CreatingProfileScreen")
    data object ChoosingGoalScreen : Route("ChoosingGoalScreen")
    data object SuccessRegistrationScreen : Route("SuccessRegistrationScreen")

    data object HomeScreen : Route("HomeScreen")
    data object NotificationScreen : Route("NotificationScreen")
    data object ActivityTrackerScreen : Route("ActivityTrackerScreen")
    data object ProfileScreen : Route("ProfileScreen")
    data object WorkoutTrackerScreen : Route("WorkoutTracker")

    data object CategoryBreakfastScreen : Route("CategoryBreakfastScreen")


    data object SleepTrackerScreen : Route("SleepTrackerScreen")
}