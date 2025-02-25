package com.example.proff.feature_app.domain.usecase.User

import com.example.proff.feature_app.domain.model.HeartRate
import com.example.proff.feature_app.domain.repository.UserRepository

class GetHeartRateUseCase(
    private val userRepository: UserRepository
) {
    suspend operator fun invoke() : HeartRate{
        return userRepository.getHeartRate()
    }
}