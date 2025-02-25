package com.example.proff.feature_app.domain.repository

import com.example.proff.feature_app.domain.model.HeartRate
import com.example.proff.feature_app.domain.model.LastActivity
import com.example.proff.feature_app.domain.model.Notifications
import com.example.proff.feature_app.domain.model.UserData

interface UserRepository {

    suspend fun getUserData() : UserData
    suspend fun getHeartRate() : HeartRate

    suspend fun getNotifications() : List<Notifications>
    suspend fun setUserImage(byteArray: ByteArray)
    suspend fun getLastActivity() : List<LastActivity>
}