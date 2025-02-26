package com.example.proff.feature_app.domain.usecase.Workout

import com.example.proff.feature_app.domain.repository.WorkoutRepository

class SetWorkoutScheduleUseCase(
    private val workoutRepository: WorkoutRepository
) {

    suspend operator fun invoke(title: String, time: String = ""){
        workoutRepository.setWorkoutSchedule(title, time)
    }
}