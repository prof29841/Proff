package com.example.proff.feature_app.domain.usecase.User

import com.example.proff.feature_app.domain.model.Notifications
import com.example.proff.feature_app.domain.repository.UserRepository

class GetNotificationsUseCase(
    private val userRepository: UserRepository
) {

    suspend operator fun invoke() : List<Notifications> {
        return userRepository.getNotifications()
    }
}