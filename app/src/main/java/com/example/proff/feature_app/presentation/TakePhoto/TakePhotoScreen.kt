package com.example.proff.feature_app.presentation.TakePhoto

import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.proff.R
import com.example.proff.feature_app.presentation.common.CustomAlertDialog
import com.example.proff.feature_app.presentation.common.CustomIndicator
import com.example.proff.feature_app.presentation.ui.theme._226F8F
import com.example.proff.feature_app.presentation.ui.theme._81C1CC
import com.example.proff.feature_app.presentation.ui.theme._9CE9EE
import com.example.proff.feature_app.presentation.ui.theme._B6B4C2
import com.example.proff.feature_app.presentation.ui.theme._F7F8F8
import org.koin.androidx.compose.koinViewModel

@Composable
fun TakePhotoScreen(
    navController: NavController,
    viewModel: TakePhotoViewModel = koinViewModel()
) {

    val state = viewModel.state.value
    val launcher = rememberLauncherForActivityResult(ActivityResultContracts.TakePicturePreview()) {
        if (it != null) {
            viewModel.onEvent(TakePhotoEvent.TakePhoto(it))
        }
    }

    if (state.exception.isNotEmpty()) {
        CustomAlertDialog(state.exception) {
            viewModel.onEvent(TakePhotoEvent.ResetException)
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Brush.linearGradient(listOf(_81C1CC, _226F8F))),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        AsyncImage(
            model = "https://nnctezenkkdwflrmazcg.supabase.co/storage/v1/object/public/toWork//Frame%20(2).png",
            contentDescription = null,
            modifier = Modifier
                .width(180.dp),
            contentScale = ContentScale.Fit
        )
        Spacer(Modifier.height(40.dp))
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 40.dp)
                .background(
                    Brush.linearGradient(listOf(Color.White, Color.White)),
                    RoundedCornerShape(99.dp),
                    0.8f
                ),
            colors = CardDefaults.cardColors(Color.Transparent),
            shape = RoundedCornerShape(99.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 40.dp, vertical = 15.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Icon(
                    imageVector = ImageVector.vectorResource(R.drawable.zap_icon),
                    contentDescription = null,
                    tint = Color.Unspecified
                )
                Box(
                    Modifier
                        .size(48.dp)
                        .clip(CircleShape)
                        .background(Brush.linearGradient(listOf(_226F8F, _9CE9EE)), CircleShape)
                        .clickable { launcher.launch(null) }, contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = ImageVector.vectorResource(R.drawable.camera_icon),
                        contentDescription = null,
                        tint = Color.White,
                        modifier = Modifier
                            .padding(12.dp)
                    )
                }
                Icon(
                    imageVector = ImageVector.vectorResource(R.drawable.camera_icon),
                    contentDescription = null,
                    tint = _B6B4C2
                )
            }
        }
        Spacer(Modifier.height(20.dp))

        Box(
            Modifier
                .fillMaxWidth()
                .background(Color.White),
            contentAlignment = Alignment.Center
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        start = 30.dp,
                        end = 30.dp,
                        bottom = (LocalConfiguration.current.screenHeightDp / 20).dp,
                        top = 30.dp
                    ),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                repeat(4) {
                    Box(
                        Modifier
                            .size(65.dp)
                            .clip(RoundedCornerShape(12.dp))
                            .background(_F7F8F8, RoundedCornerShape(12.dp)),
                        contentAlignment = Alignment.Center
                    ) {
                        AsyncImage(
                            model = when (it){
                                1 -> {"https://nnctezenkkdwflrmazcg.supabase.co/storage/v1/object/public/toWork//Group.png"}
                                2 -> {"https://nnctezenkkdwflrmazcg.supabase.co/storage/v1/object/public/toWork//Vector%20(5).png"}
                                3 -> {"https://nnctezenkkdwflrmazcg.supabase.co/storage/v1/object/public/toWork//Vector%20(6).png"}
                                else -> {"https://nnctezenkkdwflrmazcg.supabase.co/storage/v1/object/public/toWork//Vector%20(7).png"}
                            },
                            contentDescription = null,
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(horizontal = 25.dp, vertical = 5.dp),
                            contentScale = ContentScale.Fit
                        )
                    }
                }
            }
        }
    }

    CustomIndicator(state.showIndicator)
}