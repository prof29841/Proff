package com.example.proff.feature_app.domain.repository

import com.example.proff.feature_app.domain.model.AllWorkoutDetails
import com.example.proff.feature_app.domain.model.SomeWorkoutDetails
import com.example.proff.feature_app.domain.model.AllWorkoutsData
import com.example.proff.feature_app.domain.model.UserWorkoutSchedule
import com.example.proff.feature_app.domain.model.UserWorkoutTracker

interface WorkoutRepository {

    suspend fun getUserWorkoutTrackers() : List<UserWorkoutTracker>
    suspend fun getAllWorkouts() : List<AllWorkoutsData>

    suspend fun getSomeWorkoutDetails(id: Int) : List<SomeWorkoutDetails>
    suspend fun getAllWorkoutDetails(id: Int) : AllWorkoutDetails

    suspend fun setWorkoutSchedule(title: String, time: String = "")
    suspend fun getWorkoutSchedule() : List<UserWorkoutSchedule>

    suspend fun changeEnabledToUserWorkoutTracker(id: Int, enabled: Boolean)
}