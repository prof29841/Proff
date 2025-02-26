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
import com.example.proff.feature_app.presentation.ChoosingGoal.ChoosingGoalScreen
import com.example.proff.feature_app.presentation.CreatingProfile.CreatingProfileScreen
import com.example.proff.feature_app.presentation.Home.HomeScreen
import com.example.proff.feature_app.presentation.Notification.NotificationScreen
import com.example.proff.feature_app.presentation.OnBoard.OnBoardScreen
import com.example.proff.feature_app.presentation.Profile.ProfileScreen
import com.example.proff.feature_app.presentation.SignIn.SignInScreen
import com.example.proff.feature_app.presentation.SignUp.SignUpScreen
import com.example.proff.feature_app.presentation.Splash.SplashScreen
import com.example.proff.feature_app.presentation.SuccessRegistration.SuccessRegistrationScreen
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

                    }


                    composable(Route.SleepTrackerScreen.route){

                    }
                }
            }
        }
    }
}
