package com.example.proff.feature_app.data.repository

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.util.Log
import com.example.proff.feature_app.data.network.Supabase.client
import com.example.proff.feature_app.domain.model.Gallery
import com.example.proff.feature_app.domain.repository.PhotoRepository
import io.github.jan.supabase.auth.auth
import io.github.jan.supabase.postgrest.postgrest
import io.github.jan.supabase.storage.storage
import kotlin.time.Duration

/**
 * Класс для работы с галлереей пользователя
 * @author Андреев Арсений 27.02.2025 12:23
 */
class PhotoRepositoryImpl : PhotoRepository {
    override suspend fun getPhotos(): List<Gallery> {
        val userID = getUserID()

        return client.postgrest["Gallery"].select {
            filter { eq("userID", userID) }
        }.decodeList<Gallery>()
    }

    override suspend fun addPhoto(byteArray: ByteArray) {
        val userID = getUserID()
        val bitmap = byteArray.toBitmap()

        val bucket = client.storage.from("gallery")
        bucket.upload("$userID/${bitmap}.png", byteArray)

        val url = bucket.createSignedUrl("$userID/${bitmap}.png", Duration.INFINITE)

        Log.e("url", url)
        client.postgrest["Gallery"].insert(mapOf(
            "userID" to userID,
            "photo" to url
        ))
    }

    private suspend fun getUserID() : String{
        client.auth.awaitInitialization()
        return client.auth.currentUserOrNull()?.id ?: ""
    }

    private fun ByteArray.toBitmap() : Bitmap{
        return BitmapFactory.decodeByteArray(this, 0, this.size)
    }
}