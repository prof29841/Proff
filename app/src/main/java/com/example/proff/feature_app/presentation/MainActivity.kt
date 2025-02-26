package com.example.proff.feature_app.presentation

import android.os.Bundle
import android.view.View
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.shrinkHorizontally
import androidx.compose.animation.slideInHorizontally
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.proff.feature_app.presentation.ActivityTracker.ActivityTrackerScreen
import com.example.proff.feature_app.presentation.AddWorkoutSchedule.AddWorkoutScheduleScreen
import com.example.proff.feature_app.presentation.CategoryBreakfast.CategoryBreakfastScreen
import com.example.proff.feature_app.presentation.ChoosingGoal.ChoosingGoalScreen
import com.example.proff.feature_app.presentation.CongratulationsPage.CongratulationsPageScreen
import com.example.proff.feature_app.presentation.CreatingProfile.CreatingProfileScreen
import com.example.proff.feature_app.presentation.Home.HomeScreen
import com.example.proff.feature_app.presentation.Notification.NotificationScreen
import com.example.proff.feature_app.presentation.OnBoard.OnBoardScreen
import com.example.proff.feature_app.presentation.Profile.ProfileScreen
import com.example.proff.feature_app.presentation.SignIn.SignInScreen
import com.example.proff.feature_app.presentation.SignUp.SignUpScreen
import com.example.proff.feature_app.presentation.Splash.SplashScreen
import com.example.proff.feature_app.presentation.SuccessRegistration.SuccessRegistrationScreen
import com.example.proff.feature_app.presentation.WorkoutDetails1.WorkoutDetails1Screen
import com.example.proff.feature_app.presentation.WorkoutDetails2.WorkoutDetails2Screen
import com.example.proff.feature_app.presentation.WorkoutSchedule.WorkoutScheduleScreen
import com.example.proff.feature_app.presentation.WorkoutTracker.WorkoutTrackerScreen
import com.example.proff.feature_app.presentation.ui.theme.ProffTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        window.decorView.apply {
            this.systemUiVisibility = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
        }
        setContent {
            val navController = rememberNavController()
            ProffTheme {
                NavHost(
                    navController, startDestination = Route.SplashScreen.route,
                    enterTransition = {
                        slideInHorizontally(tween(500, easing = LinearOutSlowInEasing))
                    },
                    exitTransition = {
                        shrinkHorizontally(tween(500, easing = LinearOutSlowInEasing))
                    }
                ){

                    composable(Route.SplashScreen.route){
                        SplashScreen(navController)
                    }
                    composable(Route.OnBoardScreen.route){
                        OnBoardScreen(navController)
                    }


                    composable(Route.SignInScreen.route){
                        SignInScreen(navController)
                    }
                    composable(Route.SignUpScreen.route){
                        SignUpScreen(navController)
                    }
                    composable(Route.CreatingProfileScreen.route){
                        CreatingProfileScreen(navController)
                    }
                    composable(Route.ChoosingGoalScreen.route){
                        ChoosingGoalScreen(navController)
                    }
                    composable(Route.SuccessRegistrationScreen.route){
                        SuccessRegistrationScreen(navController)
                    }


                    composable(Route.HomeScreen.route){
                        HomeScreen(navController)
                    }
                    composable(Route.NotificationScreen.route){
                        NotificationScreen(navController)
                    }
                    composable(Route.ActivityTrackerScreen.route){
                        ActivityTrackerScreen(navController)
                    }
                    composable(Route.ProfileScreen.route){
                        ProfileScreen(navController)
                    }
                    composable(Route.WorkoutTrackerScreen.route){
                        WorkoutTrackerScreen(navController)
                    }
                    composable(Route.NotificationScreen.route){
                        NotificationScreen(navController)
                    }


                    composable(Route.CategoryBreakfastScreen.route){
                        CategoryBreakfastScreen(navController)
                    }
                    composable(Route.WorkoutScheduleScreen.route){
                        WorkoutScheduleScreen(navController)
                    }
                    composable(Route.WorkoutDetails1Screen.route){
                        WorkoutDetails1Screen(navController)
                    }
                    composable(Route.WorkoutDetails2Screen.route){
                        WorkoutDetails2Screen(navController)
                    }
                    composable(Route.CongratulationsPageScreen.route){
                        CongratulationsPageScreen(navController)
                    }
                    composable(Route.AddWorkoutScheduleScreen.route){
                        AddWorkoutScheduleScreen(navController)
                    }


                    composable(Route.SleepTrackerScreen.route){

                    }
                }
            }
        }
    }
}
