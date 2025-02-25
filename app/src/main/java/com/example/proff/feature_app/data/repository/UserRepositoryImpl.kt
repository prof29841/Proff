package com.example.proff.feature_app.data.repository

import com.example.proff.feature_app.data.network.Supabase.client
import com.example.proff.feature_app.domain.model.HeartRate
import com.example.proff.feature_app.domain.model.LastActivity
import com.example.proff.feature_app.domain.model.Notifications
import com.example.proff.feature_app.domain.model.UserData
import com.example.proff.feature_app.domain.repository.UserRepository
import io.github.jan.supabase.auth.auth
import io.github.jan.supabase.postgrest.postgrest
import io.github.jan.supabase.storage.storage
import kotlin.time.Duration

/**
 * Класс для работы с данными пользователями
 * @author Андреев Арсений 25.02.2025 13:02
 */
class UserRepositoryImpl : UserRepository {
    override suspend fun getUserData(): UserData {
        val userID = getUserID()

        return client.postgrest["Users"].select {
            filter { eq("userID", userID) }
        }.decodeSingle<UserData>()
    }

    override suspend fun getHeartRate(): HeartRate {
        val userID = getUserID()

        return client.postgrest["HeartRate"].select {
            filter { eq("userID", userID) }
        }.decodeSingle<HeartRate>()
    }

    override suspend fun getNotifications(): List<Notifications> {
        val userID = getUserID()

        return client.postgrest["Notifications"].select {
            filter { eq("userID", userID) }
        }.decodeList<Notifications>()
    }

    override suspend fun setUserImage(byteArray: ByteArray) {

        val userID = getUserID()

        val bucket = client.storage.from("avatars")
        bucket.upload(
            path = "$userID.png",
            data = byteArray
        ){
            this.upsert = true
        }

        val url = bucket.createSignedUrl("$userID.png", Duration.INFINITE)
        client.postgrest["Users"].update(mapOf(
            "image" to url
        )){
            filter { eq("userID", userID) }
        }
    }

    override suspend fun getLastActivity(): List<LastActivity> {
        val userID = getUserID()

        return client.postgrest["LastActivity"].select {
            filter { eq("userID", userID) }
        }.decodeList<LastActivity>()
    }

    private suspend fun getUserID() : String{
        client.auth.awaitInitialization()
        return client.auth.currentUserOrNull()?.id ?: ""
    }
}