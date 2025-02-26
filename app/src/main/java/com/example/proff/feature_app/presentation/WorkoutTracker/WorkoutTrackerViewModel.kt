package com.example.proff.feature_app.presentation.WorkoutTracker

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.proff.feature_app.domain.usecase.Workout.ChangeEnabledToUserWorkoutTrackerUseCase
import com.example.proff.feature_app.domain.usecase.Workout.GetAllWorkoutsUseCase
import com.example.proff.feature_app.domain.usecase.Workout.GetUserWorkoutTrackersUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class WorkoutTrackerViewModel(
    private val getUserWorkoutTrackersUseCase: GetUserWorkoutTrackersUseCase,
    private val getAllWorkoutsUseCase: GetAllWorkoutsUseCase,
    private val changeEnabledToUserWorkoutTrackerUseCase: ChangeEnabledToUserWorkoutTrackerUseCase
) : ViewModel() {

    private val _state = mutableStateOf(WorkoutTrackerState())
    val state: State<WorkoutTrackerState> = _state

    init {
        viewModelScope.launch(Dispatchers.IO) {
            _state.value = state.value.copy(showIndicator = true)
            try {
                getUserWorkout()
            } catch (e: Exception) {
                _state.value = state.value.copy(exception = e.message.toString())
            }
            _state.value = state.value.copy(showIndicator = false)
        }
    }

    private suspend fun getUserWorkout() {
        val userWorkout = getUserWorkoutTrackersUseCase()
        val allWorkout = getAllWorkoutsUseCase()

        withContext(Dispatchers.Main){
            _state.value = state.value.copy(
                userWorkout = userWorkout,
                allWorkout = allWorkout
            )
        }
    }

    fun onEvent(event: WorkoutTrackerEvent){
        when (event){
            is WorkoutTrackerEvent.ChangeUserWorkoutState -> {
                viewModelScope.launch(Dispatchers.IO) {
                    try {
                        changeEnabledToUserWorkoutTrackerUseCase(event.workout.id, event.value)
                    } catch (e: Exception) {
                        _state.value = state.value.copy(exception = e.message.toString())
                    }
                }
            }
            WorkoutTrackerEvent.ResetException -> {
                _state.value = state.value.copy(exception = "")
            }
        }
    }
}