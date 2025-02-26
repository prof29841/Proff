package com.example.proff.feature_app.presentation.AddWorkoutSchedule

sealed class AddWorkoutScheduleEvent {

    data object ResetException : AddWorkoutScheduleEvent()
    data object AddWorkout : AddWorkoutScheduleEvent()
}