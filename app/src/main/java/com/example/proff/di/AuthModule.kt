package com.example.proff.di

import com.example.proff.feature_app.data.repository.AuthRepositoryImpl
import com.example.proff.feature_app.domain.repository.AuthRepository
import com.example.proff.feature_app.domain.usecase.Auth.CreateProfileUseCase
import com.example.proff.feature_app.domain.usecase.Auth.SelectPurposeUseCase
import com.example.proff.feature_app.domain.usecase.Auth.SignInUseCase
import com.example.proff.feature_app.domain.usecase.Auth.SignInWithGoogleUseCase
import com.example.proff.feature_app.domain.usecase.Auth.SignUpUseCase
import org.koin.dsl.module

val moduleAuth = module {

    single<AuthRepository> {
        AuthRepositoryImpl()
    }
    factory<CreateProfileUseCase> {
        CreateProfileUseCase(get())
    }
    factory<SelectPurposeUseCase> {
        SelectPurposeUseCase(get())
    }
    factory<SignInUseCase> {
        SignInUseCase(get())
    }
    factory<SignInWithGoogleUseCase> {
        SignInWithGoogleUseCase(get())
    }
    factory<SignUpUseCase> {
        SignUpUseCase(get())
    }
}