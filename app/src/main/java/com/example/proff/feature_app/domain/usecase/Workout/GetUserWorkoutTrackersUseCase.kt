package com.example.proff.feature_app.domain.usecase.Workout

import com.example.proff.feature_app.domain.model.UserWorkoutTracker
import com.example.proff.feature_app.domain.repository.WorkoutRepository

class GetUserWorkoutTrackersUseCase(
    private val workoutRepository: WorkoutRepository
) {

    suspend operator fun invoke() : List<UserWorkoutTracker>{
        return workoutRepository.getUserWorkoutTrackers()
    }
}