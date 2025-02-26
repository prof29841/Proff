package com.example.proff.feature_app.domain.usecase.Workout

import com.example.proff.feature_app.domain.model.SomeWorkoutDetails
import com.example.proff.feature_app.domain.repository.WorkoutRepository

class GetSomeWorkoutDetailsUseCase(
    private val workoutRepository: WorkoutRepository
) {

    suspend operator fun invoke(id: Int) : List<SomeWorkoutDetails>{
        return workoutRepository.getSomeWorkoutDetails(id)
    }
}