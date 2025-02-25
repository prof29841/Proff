package com.example.proff.feature_app.data.repository

import com.example.proff.feature_app.data.network.Supabase.client
import com.example.proff.feature_app.domain.model.UserData
import com.example.proff.feature_app.domain.repository.AuthRepository
import io.github.jan.supabase.auth.auth
import io.github.jan.supabase.auth.providers.builtin.Email
import io.github.jan.supabase.postgrest.postgrest


/**
 * Класс для авторизации и регистрации.
 * @authorАндреев Арсений
 */
class AuthRepositoryImpl : AuthRepository {

    //вход
    override suspend fun signIn(mail: String, pass: String) {
        client.auth.signInWith(Email){
            email = mail
            password = pass
        }
    }

    //вход с гуглом
    override suspend fun signInWithGoogle() : Boolean {

        val userID = getUserID()

        try {
            client.postgrest["Users"].select {
                filter { eq("userID", userID) }
            }
            return true
        } catch (e: Exception) {
            return false
        }
    }

    //регистрация
    override suspend fun signUp(mail: String, pass: String, userData: UserData) {

        client.auth.signUpWith(Email){
            email = mail
            password = pass
        }

        val userID = getUserID()

        client.postgrest["Users"].insert(mapOf(
            "userID" to userID,
            "fio" to userData.fio,
            "phone" to userData.phone
        ))
    }

    //внесение допДанных
    override suspend fun createProfile(userData: UserData) {
        val userID = getUserID()

        client.postgrest["Users"].update(mapOf(
            "gender" to userData.gender,
            "birthdayData" to userData.birthdayData,
            "weight" to userData.weight,
            "height" to userData.height
        )){
            filter { eq("userID", userID) }
        }
    }

    //выбор цели(внесение допДанных)
    override suspend fun selectPurpose(userData: UserData) {
        val userID = getUserID()

        client.postgrest["Users"].update(mapOf(
            "purpose" to userData.purpose
        )){
            filter { eq("userID", userID) }
        }
    }

    private suspend fun getUserID() : String{
        client.auth.awaitInitialization()
        return client.auth.currentUserOrNull()?.id ?: ""
    }

}