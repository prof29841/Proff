package com.example.proff.feature_app.presentation.WorkoutDetails1

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.proff.feature_app.domain.usecase.Workout.GetSomeWorkoutDetailsUseCase
import com.example.proff.feature_app.presentation.Route
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class WorkoutDetails1ViewModel(
    private val getSomeWorkoutDetailsUseCase: GetSomeWorkoutDetailsUseCase
) : ViewModel() {

    private val _state = mutableStateOf(WorkoutDetails1State())
    val state: State<WorkoutDetails1State> = _state

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
        val details = getSomeWorkoutDetailsUseCase(Route.WorkoutDetails1Screen.workout.id)

        withContext(Dispatchers.Main){
            _state.value = state.value.copy(
                details = details
            )
        }

        val items = Route.WorkoutDetails1Screen.workout.items
        var item1 = ""
        items.forEach {
            if (it.toString() != ","){
                item1 += it
            }else{
                withContext(Dispatchers.Main){
                    _state.value = state.value.copy(
                        items = _state.value.items+1,
                        itemsList = _state.value.itemsList.plus(item1)
                    )
                }
            }
        }
    }

    fun onEvent(event: WorkoutDetails1Event){
        when (event){
            WorkoutDetails1Event.ResetException -> {
                _state.value = state.value.copy(exception = "")
            }

            WorkoutDetails1Event.StartClick -> {

            }
        }
    }
}