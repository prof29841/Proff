package com.example.proff.feature_app.data.repository

import com.example.proff.feature_app.data.network.Supabase.client
import com.example.proff.feature_app.domain.model.AllWorkoutDetails
import com.example.proff.feature_app.domain.model.AllWorkoutsData
import com.example.proff.feature_app.domain.model.SomeWorkoutDetails
import com.example.proff.feature_app.domain.model.UserWorkoutSchedule
import com.example.proff.feature_app.domain.model.UserWorkoutTracker
import com.example.proff.feature_app.domain.repository.WorkoutRepository
import io.github.jan.supabase.auth.auth
import io.github.jan.supabase.postgrest.postgrest
import java.time.LocalDate

/**
 * Класс для работы с тренировками
 * @author Андреев Арсений 26.02.2025 11:01
 */
class WorkoutRepositoryImpl : WorkoutRepository{

    override suspend fun getUserWorkoutTrackers(): List<UserWorkoutTracker> {
        val userID = getUserID()

        return client.postgrest["UserWorkoutTracker"].select {
            filter { eq("userID", userID) }
        }.decodeList<UserWorkoutTracker>()
    }

    override suspend fun getAllWorkouts(): List<AllWorkoutsData> {
        return client.postgrest["AllWorkouts"].select {  }.decodeList<AllWorkoutsData>()
    }

    override suspend fun getSomeWorkoutDetails(id: Int): List<SomeWorkoutDetails> {
        return client.postgrest["AllWorkoutsDetails"].select {
            filter { eq("id", id) }
        }.decodeList<SomeWorkoutDetails>()
    }

    override suspend fun getAllWorkoutDetails(id: Int): AllWorkoutDetails {
        return client.postgrest["AllWorkoutsDetails1"].select {
            filter { eq("workoutID", id) }
        }.decodeSingle<AllWorkoutDetails>()
    }

    override suspend fun setWorkoutSchedule(title: String, time: String) {
        val userID = getUserID()
        if (time.isBlank()){
            client.postgrest["UserWorkoutSchedule"].insert(mapOf(
                "userID" to  userID,
                "title" to title
            ))
        }else{
            client.postgrest["UserWorkoutSchedule"].insert(mapOf(
                "userID" to userID,
                "title" to title,
                "time" to time
            ))
        }
    }

    override suspend fun getWorkoutSchedule(): List<UserWorkoutSchedule> {
        val userID = getUserID()
        val date = LocalDate.now()

        return client.postgrest["UserWorkoutSchedule"].select {
            filter {
                and {
                    eq("date", date.toString())
                    eq("userID", userID)
                }
            }
        }.decodeList<UserWorkoutSchedule>()
    }

    override suspend fun changeEnabledToUserWorkoutTracker(id: Int, enabled: Boolean) {
        val userID = getUserID()

        client.postgrest["UserWorkoutTracker"].update(mapOf(
            "enabled" to enabled
        )){
            filter {
                and {
                    eq("id", id)
                    eq("userID", userID)
                }
            }
        }
    }

    private suspend fun getUserID() : String{
        client.auth.awaitInitialization()
        return client.auth.currentUserOrNull()?.id ?: ""
    }
}