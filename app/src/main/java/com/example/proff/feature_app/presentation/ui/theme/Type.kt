package com.example.proff.feature_app.presentation.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.example.proff.R

// Set of Material typography styles to start with
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    )
    /* Other default text styles to override
    titleLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    labelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
    */
)

val fontMontserratRegular = FontFamily(Font(R.font.montserrat_regular))
val fontMontserratBold = FontFamily(Font(R.font.montserrat_bold))
val fontPoppinsRegular = FontFamily(Font(R.font.poppins_regular))

val montserrat70036Bold_52B09F = TextStyle(
    fontFamily = fontMontserratBold,
    fontWeight = FontWeight(700),
    fontSize = 36.sp,
    color = _52B09F,
    textAlign = TextAlign.Center
)
val montserrat70036Bold_1D1617 = TextStyle(
    fontFamily = fontMontserratBold,
    fontWeight = FontWeight(700),
    fontSize = 36.sp,
    color = _1D1617,
    textAlign = TextAlign.Center
)
val montserrat70024Bold_1D1617 = TextStyle(
    fontFamily = fontMontserratBold,
    fontWeight = FontWeight(700),
    fontSize = 24.sp,
    color = _1D1617,
    textAlign = TextAlign.Center
)
val montserrat40018_CFCFCF = TextStyle(
    fontFamily = fontMontserratBold,
    fontWeight = FontWeight(400),
    fontSize = 18.sp,
    color = _CFCFCF,
    textAlign = TextAlign.Center
)
val montserrat40014_B6B4C2 = TextStyle(
    fontFamily = fontMontserratBold,
    fontWeight = FontWeight(400),
    fontSize = 14.sp,
    color = _B6B4C2,
    textAlign = TextAlign.Center
)