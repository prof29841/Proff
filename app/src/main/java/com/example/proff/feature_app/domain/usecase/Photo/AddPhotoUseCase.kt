package com.example.proff.feature_app.domain.usecase.Photo

import com.example.proff.feature_app.domain.repository.PhotoRepository

class AddPhotoUseCase(
    private val photoRepository: PhotoRepository
) {

    suspend operator fun invoke(byteArray: ByteArray){
        photoRepository.addPhoto(byteArray)
    }
}