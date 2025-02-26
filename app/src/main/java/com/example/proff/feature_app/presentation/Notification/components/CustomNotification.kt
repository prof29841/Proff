package com.example.proff.feature_app.presentation.Notification.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.proff.feature_app.presentation.ui.theme._00F0FF
import com.example.proff.feature_app.presentation.ui.theme._00FF66
import com.example.proff.feature_app.presentation.ui.theme._A5A3B0
import com.example.proff.feature_app.presentation.ui.theme._C6C4D4
import com.example.proff.feature_app.presentation.ui.theme.montserrat40010_B6B4C2
import com.example.proff.feature_app.presentation.ui.theme.montserrat50012_1D1617

@Composable
fun CustomNotification(
    icon: String,
    title: String,
    description: String,
    modifier: Modifier = Modifier,

    ) {
    Column(
        modifier = modifier
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Box(
                Modifier
                    .size(40.dp)
                    .clip(CircleShape)
                    .background(
                        Brush.linearGradient(
                            listOf(
                                _00F0FF, _00FF66
                            )
                        ), CircleShape
                    ),
                contentAlignment = Alignment.Center
            ){
                AsyncImage(
                    model = icon,
                    contentDescription = null,
                    modifier = Modifier
                        .size(25.dp, 20.dp)
                        .padding(7.dp),
                    contentScale = ContentScale.Crop
                )
            }
            Spacer(Modifier.width(10.dp))
            Column {
                Text(
                    text = title,
                    style = montserrat50012_1D1617
                )
                Spacer(Modifier.height(5.dp))
                Text(
                    text = description,
                    style = montserrat40010_B6B4C2
                )
            }
            Spacer(Modifier.weight(1f))
            Icon(
                imageVector = Icons.Default.MoreVert,
                contentDescription = null,
                tint = _A5A3B0
            )
        }
        Spacer(Modifier.height(15.dp))
        Box(modifier.height(1.dp).background(_C6C4D4))
    }
}