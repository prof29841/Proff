package com.example.proff.feature_app.presentation.common

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.proff.feature_app.presentation.ui.theme._226F8F
import com.example.proff.feature_app.presentation.ui.theme._81C1CC
import com.example.proff.feature_app.presentation.ui.theme.montserrat50014_1D1617

@Composable
fun CustomLightBlueCard(
    text: String,
    btnText: String,
    enabled: Boolean = true,
    modifier: Modifier = Modifier,
    btnModifier: Modifier = Modifier,
    onClick: () -> Unit
) {

    Card(
        modifier = modifier
            .clip(RoundedCornerShape(100.dp))
            .background(Brush.linearGradient(listOf(_81C1CC, _226F8F)), RoundedCornerShape(100.dp), 0.2f),
        onClick = onClick,
        enabled = enabled,
        shape = RoundedCornerShape(100.dp),
        colors = CardDefaults.cardColors(Color.Transparent)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(20.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = text,
                style = montserrat50014_1D1617
            )
            Spacer(Modifier.weight(1f))
            CustomBlueButton(
                text = btnText,
            ) { onClick() }
        }
    }
}