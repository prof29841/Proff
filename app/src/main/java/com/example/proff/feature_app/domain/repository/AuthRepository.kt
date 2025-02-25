package com.example.proff.feature_app.domain.repository

import com.example.proff.feature_app.domain.model.UserData

interface AuthRepository {

    suspend fun signIn(mail: String, pass: String)
    suspend fun signInWithGoogle() : Boolean

    suspend fun signUp(mail: String, pass: String, userData: UserData)
    suspend fun createProfile(userData: UserData)
    suspend fun selectPurpose(userData: UserData)
}