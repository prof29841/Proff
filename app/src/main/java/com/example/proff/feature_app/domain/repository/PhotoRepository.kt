package com.example.proff.feature_app.domain.repository

import com.example.proff.feature_app.domain.model.Gallery

interface PhotoRepository {

    suspend fun getPhotos() : List<Gallery>
    suspend fun addPhoto(byteArray: ByteArray)
}