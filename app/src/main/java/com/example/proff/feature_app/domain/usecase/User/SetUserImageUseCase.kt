package com.example.proff.feature_app.domain.usecase.User

import com.example.proff.feature_app.domain.repository.UserRepository

class SetUserImageUseCase(
    private val userRepository: UserRepository
) {

    suspend operator fun invoke(byteArray: ByteArray){
        userRepository.setUserImage(byteArray)
    }
}