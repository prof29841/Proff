package com.example.proff.feature_app.presentation.Splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.proff.R
import com.example.proff.feature_app.presentation.Route
import com.example.proff.feature_app.presentation.ui.theme.montserrat40018_CFCFCF
import com.example.proff.feature_app.presentation.ui.theme.montserrat70036Bold_1D1617
import com.example.proff.feature_app.presentation.ui.theme.montserrat70036Bold_52B09F

@Composable
fun SplashScreen(
    navController: NavController,
    viewModel: SplashViewModel =  viewModel()
) {
    val state = viewModel.state.value

    LaunchedEffect(key1 = !state.isComplete) {
        if (state.isComplete){
            navController.navigate(Route.OnBoardScreen.route){
                popUpTo(Route.SplashScreen.route){
                    inclusive = true
                }
            }
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(start = 30.dp, end = 30.dp, top = (LocalConfiguration.current.screenHeightDp / 15).dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(R.drawable.splash_icon),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth(),
            contentScale = ContentScale.Crop
        )
        Spacer(Modifier.height(15.dp))
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Wild",
                style = montserrat70036Bold_52B09F
            )
            Text(
                text = "Way",
                style = montserrat70036Bold_1D1617
            )
        }
        Text(
            text = "Каждый может тренироваться",
            style = montserrat40018_CFCFCF
        )
    }
}