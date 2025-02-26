package com.example.proff.feature_app.presentation.OnBoard

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.proff.feature_app.presentation.Route
import com.example.proff.feature_app.presentation.ui.theme._226F8F
import com.example.proff.feature_app.presentation.ui.theme._9CE9EE
import com.example.proff.feature_app.presentation.ui.theme.montserrat40014_B6B4C2
import com.example.proff.feature_app.presentation.ui.theme.montserrat70024Bold_1D1617
import org.koin.androidx.compose.koinViewModel

@Composable
fun OnBoardScreen(
    navController: NavController,
    viewModel: OnBoardViewModel = koinViewModel()
) {

    val state = viewModel.state.value
    val pagerState = rememberPagerState { state.list.size }

    LaunchedEffect(key1 = !state.isComplete) {
        if (state.isComplete){
            navController.navigate(Route.SignInScreen.route){
                popUpTo(Route.OnBoardScreen.route){
                    inclusive = true
                }
            }
        }
    }

    HorizontalPager(
        state = pagerState,
        modifier = Modifier
            .fillMaxSize().background(Color.White),
        userScrollEnabled = false
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(state.list[state.currentPage].image),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth(),
                contentScale = ContentScale.Crop
            )
            Spacer(Modifier.height(50.dp))
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 30.dp)
            ) {
                Text(
                    text = state.list[state.currentPage].title,
                    style = montserrat70024Bold_1D1617
                )
                Spacer(Modifier.height(15.dp))
                Text(
                    text = state.list[state.currentPage].description,
                    style = montserrat40014_B6B4C2,
                    textAlign = TextAlign.Left
                )
            }

            Box(
                Modifier
                    .fillMaxSize()
                    .padding(end = 30.dp, bottom = 45.dp),
                contentAlignment = Alignment.BottomEnd
            ){
                FloatingActionButton(
                    onClick = {viewModel.onEvent(OnBoardEvent.NextPage(state.currentPage+1))},
                    shape = CircleShape,
                    containerColor = Color.Transparent,
                    modifier = Modifier
                        .size(50.dp)
                        .clip(CircleShape)
                        .background(Brush.linearGradient(listOf(_226F8F, _9CE9EE)), CircleShape),
                    elevation = FloatingActionButtonDefaults.elevation(0.dp)
                ) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Default.KeyboardArrowRight,
                        contentDescription = null,
                        tint = Color.White
                    )
                }
            }
        }

    }
}