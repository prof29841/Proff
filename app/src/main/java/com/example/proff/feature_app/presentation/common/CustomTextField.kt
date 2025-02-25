package com.example.proff.feature_app.presentation.common

import androidx.compose.foundation.clickable
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import com.example.proff.R
import com.example.proff.feature_app.presentation.ui.theme._F7F8F8
import com.example.proff.feature_app.presentation.ui.theme.montserrat40012_ADA4A5

@Composable
fun CustomTextField(
    leadingIcon: ImageVector,
    value: String,
    onValueChange: (String) -> Unit,
    passwordState: Boolean,
    onPasswordStateChange: (Boolean) -> Unit,
    title: String,
    enabled: Boolean = true,
    isPassword: Boolean = false,
    tag: String = "tag",
    trailingIcon: ImageVector = ImageVector.vectorResource(R.drawable.eye_icon),
    modifier: Modifier = Modifier
) {
    TextField(
        value = value,
        onValueChange = onValueChange,
        visualTransformation = if (passwordState && isPassword) PasswordVisualTransformation() else VisualTransformation.None,
        modifier = modifier
            .testTag(tag),
        leadingIcon = {
            Icon(
                imageVector = leadingIcon,
                contentDescription = null,
                tint = Color.Unspecified
            )
        },
        singleLine = true,
        trailingIcon = {
            Icon(
                imageVector = trailingIcon,
                contentDescription = null,
                tint = Color.Unspecified,
                modifier = Modifier
                    .clickable { onPasswordStateChange(!passwordState) }
            )
        },
        enabled = enabled,
        colors = TextFieldDefaults.colors(
            focusedContainerColor = _F7F8F8,
            unfocusedContainerColor = _F7F8F8,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledContainerColor = _F7F8F8,
            disabledIndicatorColor = Color.Transparent
        ),
        label = {
            Text(
                text = title,
                style = montserrat40012_ADA4A5
            )
        }
    )
}