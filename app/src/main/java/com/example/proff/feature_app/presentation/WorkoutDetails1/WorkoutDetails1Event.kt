package com.example.proff.feature_app.presentation.WorkoutDetails1

sealed class WorkoutDetails1Event {

    data object ResetException : WorkoutDetails1Event()
    data object StartClick : WorkoutDetails1Event()
}