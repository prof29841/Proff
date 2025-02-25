package com.example.proff.feature_app.presentation.ChoosingGoal

import androidx.annotation.DrawableRes
import com.example.proff.R

data class ChoosingGoalItem(
    @DrawableRes val image: Int,
    val title: String,
    val description: String
)

val choosingGoalItemList = listOf(
    ChoosingGoalItem(
        R.drawable.choosing_goal_1,
        "Улучшить форму",
        "У меня мало жира в организме, и мне нужно нарастить больше мышечной массы."
    ),
    ChoosingGoalItem(
        R.drawable.choosing_goal_2,
        "Тонус",
        "Я «худой толстый». выглядят тонкими, но не имеют формы. Я хочу правильно нарастить мышечную массу"
    ),
    ChoosingGoalItem(
        R.drawable.choosing_goal_3,
        "Похудеть",
        "Мне нужно сбросить более 20 кг. Я хочу сбросить весь этот жир и набрать мышечную массу."
    )
)