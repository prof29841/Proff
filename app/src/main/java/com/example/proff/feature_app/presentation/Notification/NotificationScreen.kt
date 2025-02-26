package com.example.proff.feature_app.presentation.Notification

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.proff.feature_app.presentation.Notification.components.CustomNotification
import com.example.proff.feature_app.presentation.common.CustomAlertDialog
import com.example.proff.feature_app.presentation.common.CustomIndicator
import com.example.proff.feature_app.presentation.common.CustomTopAppBar
import org.koin.androidx.compose.koinViewModel

@Composable
fun NotificationScreen(
    navController: NavController,
    viewModel: NotificationViewModel = koinViewModel()
) {

    val state = viewModel.state.value

    if (state.exception.isNotEmpty()){
        CustomAlertDialog(state.exception) {
            viewModel.onEvent(NotificationEvent.ResetException)
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(start = 30.dp, end = 30.dp, bottom = (LocalConfiguration.current.screenHeightDp / 20).dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CustomTopAppBar(
            title = "Уведомления"
        ) { navController.popBackStack() }

        Spacer(Modifier.height(30.dp))
        LazyColumn(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            items(state.notifications){notification ->
                CustomNotification(
                    icon = notification.image,
                    title = notification.title,
                    description = notification.time,
                    modifier = Modifier
                        .fillMaxWidth()
                )
                Spacer(Modifier.height(15.dp))
            }
        }
    }

    CustomIndicator(state.showIndicator)
}