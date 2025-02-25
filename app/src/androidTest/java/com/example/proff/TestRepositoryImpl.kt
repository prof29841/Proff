package com.example.proff

import com.example.proff.feature_app.data.network.Supabase.client
import com.example.proff.feature_app.domain.model.UserData
import com.example.proff.feature_app.domain.repository.AuthRepository
import io.github.jan.supabase.auth.auth
import io.github.jan.supabase.auth.providers.builtin.Email

class TestRepositoryImpl : AuthRepository {
    override suspend fun signIn(mail: String, pass: String) {
        client.auth.signInWith(Email){
            email = mail
            password = pass
        }
    }

    override suspend fun signInWithGoogle(): Boolean {
        return true
    }

    override suspend fun signUp(mail: String, pass: String, userData: UserData) {

    }

    override suspend fun createProfile(userData: UserData) {

    }

    override suspend fun selectPurpose(userData: UserData) {

    }


}