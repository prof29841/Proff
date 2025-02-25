package com.example.proff.feature_app.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class UserData(
    val userID: String,
    val fio: String,
    val phone: String,

    val gender: String = "",
    val birthdayData: String = "",
    val weight: String = "",
    val height: String = "",

    val purpose: String = "",
    val image: String = "",
)
