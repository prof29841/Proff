package com.example.proff.feature_app.domain.usecase.User

import com.example.proff.feature_app.domain.model.LastActivity
import com.example.proff.feature_app.domain.repository.UserRepository

class GetLastActivityUseCase(
    private val userRepository: UserRepository
) {

    suspend operator fun invoke() : List<LastActivity>{
        return userRepository.getLastActivity()
    }
}