package com.example.proff.feature_app.presentation.WorkoutSchedule

sealed class WorkoutScheduleEvent {

    data object ResetException : WorkoutScheduleEvent()
}