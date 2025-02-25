package com.example.proff.feature_app.presentation.OnBoard

import androidx.annotation.DrawableRes
import com.example.proff.R

data class OnBoardItem(
    @DrawableRes val image: Int,
    val title: String,
    val description: String
)

val onBoardItemList = listOf(
    OnBoardItem(
        R.drawable.onboard_1,
        "Сжигай лишнее",
        "Давайте продолжать заниматься, чтобы достичь своих целей, это больно только временно, если ты сдашься сейчас, тебе будет больно навсегда."
    ),
    OnBoardItem(
        R.drawable.onboard_2,
        "Питайся правильно",
        "Давайте начнем здоровый образ жизни вместе с нами, мы сможем определять ваш рацион каждый день. Здоровое питание - это весело"
    ),
    OnBoardItem(
        R.drawable.onboard_3,
        "Улучшите качество сна",
        "Улучшайте качество своего сна вместе с нами, качественный сон может принести хорошее настроение с утра."
    )
)
