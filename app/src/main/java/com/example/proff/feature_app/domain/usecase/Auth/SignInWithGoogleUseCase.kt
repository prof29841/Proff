package com.example.proff.feature_app.domain.usecase.Auth

import com.example.proff.feature_app.domain.repository.AuthRepository

class SignInWithGoogleUseCase(
    private val authRepository: AuthRepository
) {

    suspend operator fun invoke() : Boolean{
        return authRepository.signInWithGoogle()
    }
}