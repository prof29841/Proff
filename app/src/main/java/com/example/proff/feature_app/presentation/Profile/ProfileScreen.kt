package com.example.proff.feature_app.presentation.Profile

import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import co.yml.charts.common.extensions.isNotNull
import coil.compose.AsyncImage
import com.example.proff.R
import com.example.proff.feature_app.presentation.Profile.components.CustomProfileDetails
import com.example.proff.feature_app.presentation.Route
import com.example.proff.feature_app.presentation.common.CustomAlertDialog
import com.example.proff.feature_app.presentation.common.CustomBlueButton
import com.example.proff.feature_app.presentation.common.CustomBottomNavigation
import com.example.proff.feature_app.presentation.common.CustomIndicator
import com.example.proff.feature_app.presentation.common.CustomSwitch
import com.example.proff.feature_app.presentation.common.CustomTopAppBar
import com.example.proff.feature_app.presentation.ui.theme._1D161712
import com.example.proff.feature_app.presentation.ui.theme._B6B4C2
import com.example.proff.feature_app.presentation.ui.theme._C4C4C4
import com.example.proff.feature_app.presentation.ui.theme.montserrat40012_B6B4C2
import com.example.proff.feature_app.presentation.ui.theme.montserrat50014_1D1617
import com.example.proff.feature_app.presentation.ui.theme.montserrat60016Bold_1D1617
import com.example.proff.feature_app.presentation.ui.theme.poppins40012_B6B4C2
import com.example.proff.feature_app.presentation.ui.theme.poppins50014_226F8F
import org.koin.androidx.compose.koinViewModel

@Composable
fun ProfileScreen(
    navController: NavController,
    viewModel: ProfileViewModel = koinViewModel()
) {

    val state = viewModel.state.value
    val context = LocalContext.current
    val launcher = rememberLauncherForActivityResult(ActivityResultContracts.GetContent()) {
        if (it.isNotNull()) {
            viewModel.onEvent(ProfileEvent.SetImageView(it.toString()))
            val item = context.contentResolver.openInputStream(it!!)
            viewModel.onEvent(ProfileEvent.SetImage(item!!.readBytes()))
            item.close()
        }
    }
    val userDataList = listOf(
        state.userData?.height,
        state.userData?.weight,
        state.userData?.birthdayData,
    )
    val informationList = listOf("Рост","Вес","Лет",)
    val accountDataList = listOf(
        listOf(
            ImageVector.vectorResource(R.drawable.profile_profile_icon),
            "Данные аккаунта"
        ),
        listOf(
            ImageVector.vectorResource(R.drawable.profile_achievement_icon),
            "Достижения"
        ),
        listOf(
            ImageVector.vectorResource(R.drawable.profile_activity_icon),
            "История активности"
        ),
        listOf(
            ImageVector.vectorResource(R.drawable.profile_workout_icon),
            "Прогресс занятий"
        ),
    )
    val otherDataList = listOf(
        listOf(
            ImageVector.vectorResource(R.drawable.profile_message_icon),
            "Контакты"
        ),
        listOf(
            ImageVector.vectorResource(R.drawable.profile_privacy_icon),
            "Политика кондефициальности"
        ),
        listOf(
            ImageVector.vectorResource(R.drawable.profile_settings_icon),
            "Настройки"
        ),
    )

    if (state.exception.isNotEmpty()) {
        CustomAlertDialog(state.exception) {
            viewModel.onEvent(ProfileEvent.ResetException)
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        CustomTopAppBar(
            title = "Профиль",
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 30.dp)
        ) { navController.popBackStack() }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 30.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                AnimatedVisibility(
                    visible = state.userData.isNotNull() && state.image.isNotEmpty(),
                    enter = fadeIn(tween(500)),
                    modifier = Modifier
                        .size(55.dp)
                        .clip(CircleShape)
                        .background(_C4C4C4, CircleShape),
                ) {
                    AsyncImage(
                        model = state.image,
                        contentDescription = null,
                        modifier = Modifier
                            .size(40.dp, 50.dp)
                            .clip(CircleShape)
                            .padding(7.dp),
                        contentScale = ContentScale.Crop
                    )
                }
                Spacer(Modifier.width(15.dp))
                androidx.compose.animation.AnimatedVisibility(
                    visible = state.userData.isNotNull(),
                    enter = fadeIn(tween(500)),
                ) {
                    Column {
                        Text(
                            text = state.userData!!.fio,
                            style = montserrat50014_1D1617
                        )
                        Spacer(Modifier.height(5.dp))
                        Text(
                            text = state.userData.purpose,
                            style = montserrat40012_B6B4C2
                        )
                    }
                }
                Spacer(Modifier.weight(1f))
                CustomBlueButton(
                    text = "Изменить"
                ) { launcher.launch("image/*") }
            }
            Spacer(Modifier.height(15.dp))
            LazyRow(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                repeat(3) {
                    item {
                        Card(
                            modifier = Modifier
                                .shadow(10.dp, RoundedCornerShape(16.dp), spotColor = _1D161712),
                            colors = CardDefaults.cardColors(Color.White)
                        ) {
                            Column(
                                modifier = Modifier
                                    .padding(vertical = 10.dp, horizontal = 30.dp)
                            ) {
                                androidx.compose.animation.AnimatedVisibility(
                                    visible = state.userData.isNotNull(),
                                    enter = fadeIn(tween(500))
                                ) {
                                    Text(
                                        text = userDataList[it]!!,
                                        style = poppins50014_226F8F
                                    )
                                }
                                Spacer(Modifier.height(5.dp))
                                Text(
                                    text = informationList[it],
                                    style = poppins40012_B6B4C2
                                )
                            }
                        }
                    }
                }
            }
        }


        Spacer(Modifier.height(30.dp))
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.8f)
                .padding(horizontal = 30.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            item{
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .shadow(10.dp, RoundedCornerShape(16.dp, ), spotColor = _1D161712),
                    colors = CardDefaults.cardColors(Color.White)
                ) {
                    Column(
                        modifier = Modifier
                            .padding(20.dp)
                    ) {
                        Text(
                            text = "Аккаунт",
                            style = montserrat60016Bold_1D1617
                        )
                        Spacer(Modifier.height(15.dp))
                        accountDataList.forEach {
                            CustomProfileDetails(
                                icon = it[0] as ImageVector,
                                title = it[1] as String,
                                modifier = Modifier
                                    .fillMaxWidth()
                            ) { }
                            Spacer(Modifier.height(10.dp))
                        }
                    }
                }
                Spacer(Modifier.height(15.dp))

                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .shadow(10.dp, RoundedCornerShape(16.dp, ), spotColor = _1D161712),
                    colors = CardDefaults.cardColors(Color.White)
                ) {
                    Column(
                        modifier = Modifier
                            .padding(20.dp)
                    ) {
                        Text(
                            text = "Уведомления",
                            style = montserrat60016Bold_1D1617
                        )
                        Spacer(Modifier.height(15.dp))
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier
                                .clickable { viewModel.onEvent(ProfileEvent.SwitchStateChange(!state.switchState)) }
                        ) {
                            Icon(
                                imageVector = ImageVector.vectorResource(R.drawable.profile_notification_icon),
                                contentDescription = null,
                                tint = Color.Unspecified
                            )
                            Spacer(Modifier.width(10.dp))
                            Text(
                                text = "Уведомления",
                                style = poppins40012_B6B4C2
                            )
                            Spacer(Modifier.weight(1f))

                            CustomSwitch(
                                state.switchState,
                                enabled = !state.showIndicator
                            ) { viewModel.onEvent(ProfileEvent.SwitchStateChange(it)) }
                        }
                    }
                }

                Spacer(Modifier.height(15.dp))
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .shadow(10.dp, RoundedCornerShape(16.dp, ), spotColor = _1D161712),
                    colors = CardDefaults.cardColors(Color.White)
                ) {
                    Column(
                        modifier = Modifier
                            .padding(20.dp)
                    ) {
                        Text(
                            text = "Остальное",
                            style = montserrat60016Bold_1D1617
                        )
                        Spacer(Modifier.height(15.dp))
                        otherDataList.forEach {
                            CustomProfileDetails(
                                icon = it[0] as ImageVector,
                                title = it[1] as String,
                                modifier = Modifier
                                    .fillMaxWidth()
                            ) { }
                            Spacer(Modifier.height(10.dp))
                        }
                    }
                }
            }
        }

        Spacer(Modifier.weight(1f))
        CustomBottomNavigation(
            Route.ProfileScreen,
            navController,
            modifier = Modifier.fillMaxWidth()
        )
    }

    CustomIndicator(state.showIndicator)
}