package com.example.proff.feature_app.domain.usecase.User

import com.example.proff.feature_app.domain.model.UserData
import com.example.proff.feature_app.domain.repository.UserRepository

class GetUserDataUseCase(
    private val userRepository: UserRepository
) {

    suspend operator fun invoke() : UserData{
        return userRepository.getUserData()
    }
}