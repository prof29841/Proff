package com.example.proff.feature_app.presentation.CategoryBreakfast

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.proff.feature_app.presentation.common.CustomAlertDialog
import com.example.proff.feature_app.presentation.common.CustomIndicator
import com.example.proff.feature_app.presentation.common.CustomTopAppBar
import com.example.proff.feature_app.presentation.ui.theme._226F8F
import com.example.proff.feature_app.presentation.ui.theme._9CE9EE
import com.example.proff.feature_app.presentation.ui.theme.montserrat40012_1D1617
import com.example.proff.feature_app.presentation.ui.theme.montserrat60016Bold_1D1617
import org.koin.androidx.compose.koinViewModel

@Composable
fun CategoryBreakfastScreen(
    navController: NavController,
    viewModel: CategoryBreakfastViewModel = koinViewModel()
) {

    val state = viewModel.state.value
    if (state.exception.isNotEmpty()){
        CustomAlertDialog(state.exception) {
            viewModel.onEvent(CategoryBreakfastEvent.ResetException)
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(
                start = 30.dp, end = 30.dp,
                bottom = (LocalConfiguration.current.screenHeightDp / 20).dp
            ),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CustomTopAppBar(
            title = "Завтрак"
        ) { navController.popBackStack() }

        Text(
            text = "Категории",
            style = montserrat60016Bold_1D1617
        )
        Spacer(Modifier.height(15.dp))
        LazyRow(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            items(state.categories){
                Box(
                    Modifier.clip(RoundedCornerShape(16.dp)).background(Brush.linearGradient(listOf(
                        _226F8F, _9CE9EE)), RoundedCornerShape(16.dp), 0.2f
                    ),
                    contentAlignment = Alignment.Center
                ){
                    Column(
                        modifier = Modifier
                            .padding(15.dp)
                    ) {
                        Box(Modifier.clip(CircleShape).background(Color.White, CircleShape)){
                            AsyncImage(
                                model = it.image,
                                contentDescription = null,
                                contentScale = ContentScale.Fit,
                                modifier = Modifier
                                    .padding(5.dp)
                            )
                        }
                        Spacer(Modifier.height(10.dp))
                        Text(
                            text = it.name,
                            style = montserrat40012_1D1617
                        )
                    }
                }
                Spacer(Modifier.width(15.dp))
            }
        }
    }

    CustomIndicator(state.showIndicator)
}