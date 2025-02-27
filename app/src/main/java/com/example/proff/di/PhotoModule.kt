package com.example.proff.di

import com.example.proff.feature_app.data.repository.PhotoRepositoryImpl
import com.example.proff.feature_app.domain.repository.PhotoRepository
import com.example.proff.feature_app.domain.usecase.Photo.AddPhotoUseCase
import com.example.proff.feature_app.domain.usecase.Photo.GetPhotosUseCase
import org.koin.dsl.module

val modulePhoto = module {

    single<PhotoRepository> {
        PhotoRepositoryImpl()
    }
    factory<AddPhotoUseCase> {
        AddPhotoUseCase(get())
    }
    factory<GetPhotosUseCase> {
        GetPhotosUseCase(get())
    }
}