package com.example.proff.feature_app.domain.usecase.Workout

import com.example.proff.feature_app.domain.model.AllWorkoutDetails
import com.example.proff.feature_app.domain.repository.WorkoutRepository

class GetAllWorkoutDetailsUseCase(
    private val workoutRepository: WorkoutRepository
) {

    suspend operator fun invoke(id: Int) : List<AllWorkoutDetails>{
        return workoutRepository.getAllWorkoutDetails(id)
    }
}