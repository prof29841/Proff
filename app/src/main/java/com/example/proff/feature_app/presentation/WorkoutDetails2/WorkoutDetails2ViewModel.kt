package com.example.proff.feature_app.presentation.WorkoutDetails2

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.proff.feature_app.domain.usecase.Workout.GetAllWorkoutDetailsUseCase
import com.example.proff.feature_app.presentation.Route
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class WorkoutDetails2ViewModel(
    private val getAllWorkoutDetailsUseCase: GetAllWorkoutDetailsUseCase
) : ViewModel() {

    private val _state = mutableStateOf(WorkoutDetails2State())
    val state: State<WorkoutDetails2State> = _state

    init {
        viewModelScope.launch(Dispatchers.IO) {
            _state.value = state.value.copy(showIndicator = true)
            try {
                getWorkoutDetails()
            } catch (e: Exception) {
                _state.value = state.value.copy(exception = e.message.toString())
            }
            _state.value = state.value.copy(showIndicator = false)
        }
    }

    private suspend fun getWorkoutDetails() {
        val details = getAllWorkoutDetailsUseCase(Route.WorkoutDetails2Screen.workout.workoutID)

        withContext(Dispatchers.Main){
            _state.value = state.value.copy(allWorkoutsData = details)
        }
    }

    fun onEvent(event: WorkoutDetails2Event){
        when (event){
            WorkoutDetails2Event.ResetException -> {
                _state.value = state.value.copy(exception = "")
            }
        }
    }
}