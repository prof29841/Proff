package com.example.proff.feature_app.presentation.common

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import com.example.proff.R
import com.example.proff.feature_app.presentation.ui.theme._226F8F
import com.example.proff.feature_app.presentation.ui.theme._9CE9EE
import com.example.proff.feature_app.presentation.ui.theme.montserrat70016BoldWhite

@Composable
fun CustomBlueButton(
    text: String,
    enabled: Boolean = true,
    isNextButton: Boolean = false,
    isSignInButton: Boolean = false,
    tag: String = "btn",
    buttonColor: Color? = null,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {

    Button(
        onClick = onClick,
        modifier = modifier
            .clip(RoundedCornerShape(99.dp))
            .background(
                brush = if (buttonColor != null) {
                    Brush.linearGradient(listOf(buttonColor, buttonColor))
                } else {
                    Brush.linearGradient(listOf(_226F8F, _9CE9EE))
                }, RoundedCornerShape(99.dp)
            )
            .testTag(tag),
        enabled = enabled,
        shape = RoundedCornerShape(99.dp),
        colors = ButtonDefaults.buttonColors(Color.Transparent)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            if (isSignInButton) {
                Icon(
                    imageVector = ImageVector.vectorResource(R.drawable.signin_icon),
                    contentDescription = null,
                    tint = Color.White
                )
                Spacer(Modifier.width(10.dp))
            }
            Text(
                text = text,
                style = montserrat70016BoldWhite
            )
            if (isNextButton) {
                Spacer(Modifier.width(5.dp))
                Icon(
                    imageVector = Icons.AutoMirrored.Default.KeyboardArrowRight,
                    contentDescription = null,
                    tint = Color.White
                )
            }
        }
    }
}