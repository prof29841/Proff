package com.example.proff.feature_app.domain.usecase.Workout

import com.example.proff.feature_app.domain.model.UserWorkoutSchedule
import com.example.proff.feature_app.domain.repository.WorkoutRepository

class GetWorkoutScheduleUseCase(
    private val workoutRepository: WorkoutRepository
) {

    suspend operator fun invoke() : List<UserWorkoutSchedule>{
        return workoutRepository.getWorkoutSchedule()
    }
}