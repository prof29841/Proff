package com.example.proff.feature_app.domain.usecase.Auth

import com.example.proff.feature_app.domain.model.UserData
import com.example.proff.feature_app.domain.repository.AuthRepository

class SelectPurposeUseCase(
    private val authRepository: AuthRepository
) {

    suspend operator fun invoke(userData: UserData){
        authRepository.selectPurpose(userData)
    }
}