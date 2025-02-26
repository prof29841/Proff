package com.example.proff.feature_app.presentation.ActivityTracker

sealed class ActivityTrackerEvent {

    data object ResetException : ActivityTrackerEvent()
}