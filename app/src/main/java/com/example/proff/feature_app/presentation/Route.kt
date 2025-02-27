package com.example.proff.feature_app.presentation

import com.example.proff.feature_app.domain.model.AllWorkoutDetails
import com.example.proff.feature_app.domain.model.AllWorkoutsData

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
    data object WorkoutScheduleScreen : Route("WorkoutScheduleScreen")
    data object WorkoutDetails1Screen : Route("WorkoutDetails1Screen"){
        var workout = AllWorkoutsData(0, "","","","")
    }
    data object WorkoutDetails2Screen : Route("WorkoutDetails2Screen"){
        var workout = AllWorkoutDetails(0, 0, "","","")
    }
    data object CongratulationsPageScreen : Route("CongratulationsPageScreen")
    data object AddWorkoutScheduleScreen : Route("AddWorkoutScheduleScreen")


    data object SleepTrackerScreen : Route("SleepTrackerScreen")
    data object SleepScheduleScreen : Route("SleepScheduleScreen")
    data object AddAlarmScreen : Route("AddAlarmScreen")
    data object ProgressPhotoScreen : Route("ProgressPhotoScreen")
    data object TakePhotoScreen : Route("TakePhotoScreen")
    data object ComparisonScreen : Route("ComparisonScreen")
    data object CompareResultScreen : Route("CompareResultScreen")
}
