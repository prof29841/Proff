package com.example.proff.feature_app.domain.usecase.Photo

import com.example.proff.feature_app.domain.model.Gallery
import com.example.proff.feature_app.domain.repository.PhotoRepository

class GetPhotosUseCase(
    private val photoRepository: PhotoRepository
) {

    suspend operator fun invoke() : List<Gallery>{
        return photoRepository.getPhotos()
    }
}