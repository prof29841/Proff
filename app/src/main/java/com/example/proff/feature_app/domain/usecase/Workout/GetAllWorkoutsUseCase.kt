package com.example.proff.feature_app.domain.usecase.Workout

import com.example.proff.feature_app.domain.model.AllWorkoutsData
import com.example.proff.feature_app.domain.repository.WorkoutRepository

class GetAllWorkoutsUseCase(
    private val workoutRepository: WorkoutRepository
) {

    suspend operator fun invoke() : List<AllWorkoutsData>{
        return workoutRepository.getAllWorkouts()
    }
}