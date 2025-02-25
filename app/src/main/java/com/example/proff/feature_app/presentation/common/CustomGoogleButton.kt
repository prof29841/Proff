package com.example.proff.feature_app.presentation.common

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.proff.R
import com.example.proff.feature_app.presentation.ui.theme._DDDADA

@Composable
fun CustomGoogleButton(
    enabled: Boolean = true,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Card(
        modifier = modifier,
        onClick = onClick,
        enabled = enabled,
        colors = CardDefaults.cardColors(Color.Transparent),
        shape = RoundedCornerShape(14.dp),
        border = BorderStroke(1.dp, _DDDADA)
    ) {
        Image(
            painter = painterResource(R.drawable.google_icon),
            contentDescription = null,
            modifier = modifier
                .padding(15.dp).size(20.dp),
            contentScale = ContentScale.Crop
        )
    }
}