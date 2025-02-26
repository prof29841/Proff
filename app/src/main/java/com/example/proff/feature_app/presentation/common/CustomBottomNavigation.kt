package com.example.proff.feature_app.presentation.common

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.proff.R
import com.example.proff.feature_app.presentation.Route
import com.example.proff.feature_app.presentation.ui.theme._1D161712
import com.example.proff.feature_app.presentation.ui.theme._226F8F
import com.example.proff.feature_app.presentation.ui.theme._9CE9EE

@Composable
fun CustomBottomNavigation(
    route: Route,
    navController: NavController,
    modifier: Modifier = Modifier
) {
    val iconList = listOf(
        ImageVector.vectorResource(R.drawable.home_icon),
        ImageVector.vectorResource(R.drawable.activity_icon),
        Icons.Default.Search,
        ImageVector.vectorResource(R.drawable.camera_icon),
        ImageVector.vectorResource(R.drawable.profile_icon),
    )

    NavigationBar(
        containerColor = Color.White,
        modifier = modifier
            .shadow(10.dp, spotColor = _1D161712)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            repeat(5){repeat ->
                NavigationBarItem(
                    selected = false,
                    onClick = {
                        if (repeat == 0 && route.route != Route.HomeScreen.route){
                            navController.navigate(Route.HomeScreen.route)
                        }else if (repeat == 1 && route.route != Route.WorkoutTrackerScreen.route){
                            navController.navigate(Route.WorkoutTrackerScreen.route)
                        }else if (repeat == 4 && route.route != Route.ProfileScreen.route){
                            navController.navigate(Route.ProfileScreen.route)
                        }else if (repeat == 3 && route.route != Route.ProgressPhotoScreen.route){
                            navController.navigate(Route.ProgressPhotoScreen.route)
                        }
                    },
                    icon = {
                        if (repeat != 2){
                            if (route.route == Route.HomeScreen.route && repeat == 0){
                                Icon(
                                    imageVector = ImageVector.vectorResource(R.drawable.home_active_icon),
                                    contentDescription = null,
                                    tint = Color.Unspecified,
                                    modifier = Modifier
                                        .padding(20.dp)
                                )
                            }else if (route.route == Route.ProfileScreen.route && repeat == 4) {
                                Icon(
                                    imageVector = ImageVector.vectorResource(R.drawable.profile_active),
                                    contentDescription = null,
                                    tint = Color.Unspecified,
                                    modifier = Modifier
                                        .padding(20.dp)
                                )
                            }else{
                                Icon(
                                    imageVector = iconList[repeat],
                                    contentDescription = null,
                                    tint = Color.Unspecified,
                                    modifier = Modifier
                                        .padding(20.dp)
                                )
                            }
                        }else{
                            Box(
                                Modifier
                                    .size(60.dp)
                                    .clip(CircleShape)
                                    .background(Brush.linearGradient(listOf(_226F8F, _9CE9EE)), CircleShape),
                                contentAlignment = Alignment.Center
                            ){
                                Icon(
                                    imageVector = iconList[repeat],
                                    contentDescription = null,
                                    tint = Color.White,
                                    modifier = Modifier
                                        .padding(20.dp)
                                )
                            }
                        }
                    }
                )
            }
        }
    }
}