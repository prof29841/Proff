package com.example.proff.feature_app.presentation.WorkoutTracker

import com.example.proff.feature_app.domain.model.UserWorkoutTracker

sealed class WorkoutTrackerEvent {

    data object ResetException : WorkoutTrackerEvent()

    data class ChangeUserWorkoutState(val workout: UserWorkoutTracker, val value: Boolean) : WorkoutTrackerEvent()
}