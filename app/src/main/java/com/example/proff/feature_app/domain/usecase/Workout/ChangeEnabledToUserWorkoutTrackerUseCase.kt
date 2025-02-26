package com.example.proff.feature_app.domain.usecase.Workout

import com.example.proff.feature_app.domain.repository.WorkoutRepository

class ChangeEnabledToUserWorkoutTrackerUseCase(
    private val workoutRepository: WorkoutRepository
) {

    suspend operator fun invoke(id: Int, enabled: Boolean){
        workoutRepository.changeEnabledToUserWorkoutTracker(id, enabled)
    }
}