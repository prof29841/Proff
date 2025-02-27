package com.example.proff.feature_app.presentation.ProgressPhoto

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
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
import com.example.proff.feature_app.presentation.Route
import com.example.proff.feature_app.presentation.common.CustomAlertDialog
import com.example.proff.feature_app.presentation.common.CustomBlueButton
import com.example.proff.feature_app.presentation.common.CustomIndicator
import com.example.proff.feature_app.presentation.common.CustomLightBlueCard
import com.example.proff.feature_app.presentation.common.CustomTopAppBar
import com.example.proff.feature_app.presentation.ui.theme._226F8F
import com.example.proff.feature_app.presentation.ui.theme._9CE9EE
import com.example.proff.feature_app.presentation.ui.theme._B6B4C2
import com.example.proff.feature_app.presentation.ui.theme._FF0000
import com.example.proff.feature_app.presentation.ui.theme.montserrat40012_FF0000
import com.example.proff.feature_app.presentation.ui.theme.montserrat50012_1D1617
import com.example.proff.feature_app.presentation.ui.theme.montserrat50012_A5A3B0
import com.example.proff.feature_app.presentation.ui.theme.montserrat50014_1D1617
import com.example.proff.feature_app.presentation.ui.theme.montserrat60016Bold_1D1617
import org.koin.androidx.compose.koinViewModel

@Composable
fun ProgressPhotoScreen(
    navController: NavController,
    viewModel: ProgressPhotoViewModel = koinViewModel()
) {

    val state = viewModel.state.value

    if (state.exception.isNotEmpty()) {
        CustomAlertDialog(state.exception) {
            viewModel.onEvent(ProgressPhotoEvent.ResetException)
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(
                start = 30.dp,
                end = 30.dp,
                bottom = (LocalConfiguration.current.screenHeightDp / 20).dp
            ),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CustomTopAppBar(
            title = "Фото прогресса"
        ) { navController.popBackStack() }
        Spacer(Modifier.height(30.dp))
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    Brush.linearGradient(listOf(_FF0000, _FF0000)),
                    RoundedCornerShape(20.dp),
                    0.1f
                ),
            shape = RoundedCornerShape(20.dp),
            colors = CardDefaults.cardColors(Color.Transparent),
            onClick = { navController.navigate(Route.TakePhotoScreen.route) }
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .padding(15.dp)
            ) {
                AsyncImage(
                    model = "https://nnctezenkkdwflrmazcg.supabase.co/storage/v1/object/public/toWork//Vector%20(4).png",
                    contentDescription = null,
                    modifier = Modifier
                        .size(60.dp),
                    contentScale = ContentScale.Fit
                )
                Spacer(Modifier.width(10.dp))
                Column {
                    Text(
                        text = "Напоминание!",
                        style = montserrat40012_FF0000
                    )
                    Spacer(Modifier.height(5.dp))
                    Text(
                        text = "Следующие фото 8 июля",
                        style = montserrat50014_1D1617
                    )
                }
                Spacer(Modifier.weight(1f))
                Icon(
                    imageVector = Icons.Default.Close,
                    tint = _B6B4C2,
                    contentDescription = null,
                    modifier = Modifier
                        .align(Alignment.Top)
                )
            }
        }
        Spacer(Modifier.height(20.dp))

        LazyColumn(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            item {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(
                            Brush.linearGradient(listOf(_226F8F, _9CE9EE)),
                            RoundedCornerShape(22.dp),
                            0.2f
                        ),
                    shape = RoundedCornerShape(22.dp),
                    colors = CardDefaults.cardColors(Color.Transparent)
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .padding(20.dp)
                    ) {
                        Column {
                            Text(
                                text = "Отслеживайте свой\nпрогресс каждый месяц ",
                                style = montserrat50012_1D1617
                            )
                            Spacer(Modifier.height(15.dp))
                            CustomBlueButton(
                                text = "Больше",
                                modifier = Modifier
                                    .height(35.dp)
                            ) { }
                        }
                        AsyncImage(
                            model = "https://nnctezenkkdwflrmazcg.supabase.co/storage/v1/object/public/toWork//Frame%20(1).png",
                            contentDescription = null,
                            modifier = Modifier
                                .fillMaxWidth(),
                            contentScale = ContentScale.Crop
                        )
                    }
                }
                Spacer(Modifier.height(30.dp))
                CustomLightBlueCard(
                    text = "Сравните свое фото",
                    btnModifier = Modifier.height(30.dp),
                    btnText = "Сравнивать"
                ) { navController.navigate(Route.ComparisonScreen.route) }
                Spacer(Modifier.height(30.dp))
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Галлерея",
                        style = montserrat60016Bold_1D1617
                    )
                    Spacer(Modifier.weight(1f))
                    Text(
                        text = "Больше",
                        style = montserrat50012_A5A3B0
                    )
                }
                Spacer(Modifier.height(20.dp))
            }

            item {
                LazyHorizontalGrid(
                    rows = GridCells.Fixed(2),
                    modifier = Modifier
                        .fillParentMaxSize(),
                ) {
                    items(state.photos){photo ->
                        AsyncImage(
                            model = photo.photo,
                            contentDescription = null,
                            modifier = Modifier
                                .size(100.dp)
                                .clip(RoundedCornerShape(14.dp)),
                            contentScale = ContentScale.Fit
                        )
                        Spacer(Modifier.size(10.dp))
                    }
                }
            }
        }
    }

    CustomIndicator(state.showIndicator)
}