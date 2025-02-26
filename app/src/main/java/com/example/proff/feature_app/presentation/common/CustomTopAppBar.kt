@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.proff.feature_app.presentation.common

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import com.example.proff.R
import com.example.proff.feature_app.presentation.ui.theme._1D1617
import com.example.proff.feature_app.presentation.ui.theme._F7F8F8
import com.example.proff.feature_app.presentation.ui.theme.montserrat70016Bold_1D1617

@Composable
fun CustomTopAppBar(
    title: String,
    backgroundColor: Color = _F7F8F8,
    moreClick: () -> Unit = {},
    textColor: Color = _1D1617,
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
) {
    TopAppBar(
        modifier = modifier,
        colors = TopAppBarDefaults.topAppBarColors(Color.Transparent),
        title = {
            Text(
                text = title,
                style = montserrat70016Bold_1D1617,
                modifier = Modifier
                    .fillMaxWidth(),
                color = textColor
            )
        },
        navigationIcon = {
            Box(
                Modifier
                    .size(32.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .size(32.dp)
                    .background(backgroundColor, RoundedCornerShape(8.dp))
                    .clickable { onClick() },
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.AutoMirrored.Default.KeyboardArrowLeft,
                    contentDescription = null,
                    tint = _1D1617,
                    modifier = Modifier
                        .padding(5.dp)
                )
            }
        },
        actions = {
            Box(
                Modifier
                    .size(32.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .size(32.dp)
                    .background(backgroundColor, RoundedCornerShape(8.dp))
                    .clickable { moreClick() },
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = ImageVector.vectorResource(R.drawable.more_icon),
                    contentDescription = null,
                    tint = Color.Unspecified,
                    modifier = Modifier
                        .padding(5.dp)
                )
            }
        }
    )
}