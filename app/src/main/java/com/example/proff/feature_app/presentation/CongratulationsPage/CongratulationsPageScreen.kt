package com.example.proff.feature_app.presentation.CongratulationsPage

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
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.proff.feature_app.presentation.Route
import com.example.proff.feature_app.presentation.common.CustomBlueButton
import com.example.proff.feature_app.presentation.ui.theme.montserrat40012_7B6F72
import com.example.proff.feature_app.presentation.ui.theme.montserrat70020Bold_1D1617

@Composable
fun CongratulationsPageScreen(
    navController: NavController
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(
                start = 30.dp,
                end = 30.dp,
                bottom = (LocalConfiguration.current.screenHeightDp / 20).dp,
                top = (LocalConfiguration.current.screenHeightDp / 10).dp
            ),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AsyncImage(
            model = "https://nnctezenkkdwflrmazcg.supabase.co/storage/v1/object/public/toWork//Frame.png",
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
                .padding(horizontal = 30.dp),
            contentScale = ContentScale.Crop
        )
        Spacer(Modifier.height(30.dp))
        Text(
            text = "Поздравляем, вы\nзавершили тренировку",
            style = montserrat70020Bold_1D1617
        )
        Spacer(Modifier.height(15.dp))
        Text(
            text = "Упражнения – король, а питание – королева. Объедините их, и вы получите королевство.",
            style = montserrat40012_7B6F72
        )

        Spacer(Modifier.weight(1f))
        CustomBlueButton(
            text = "Завершить",
            modifier = Modifier
                .fillMaxWidth()
        ) { navController.navigate(Route.HomeScreen.route) }
    }
}