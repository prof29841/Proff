package com.example.proff.feature_app.presentation.AddWorkoutSchedule

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.proff.feature_app.domain.usecase.Workout.SetWorkoutScheduleUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.time.LocalDate

class AddWorkoutScheduleViewModel(
    private val setWorkoutScheduleUseCase: SetWorkoutScheduleUseCase
) : ViewModel() {

    private val _state = mutableStateOf(AddWorkoutScheduleState())
    val state: State<AddWorkoutScheduleState> = _state

    init {
        getDay()
    }

    private fun getDay() {
        val date = LocalDate.now()
        val dayName = date.dayOfWeek.name
        val dayNumber = date.dayOfMonth
        val monthName = date.month.name
        val year = date.year

        _state.value = state.value.copy(
            dayName = dayName,
            dayNumber = dayNumber.toString(),
            monthName = monthName,
            year = year.toString()
        )
    }

    fun onEvent(event: AddWorkoutScheduleEvent){
        when (event){
            AddWorkoutScheduleEvent.AddWorkout -> {
                _state.value = state.value.copy(exception = "")
            }
            AddWorkoutScheduleEvent.ResetException -> {
                viewModelScope.launch(Dispatchers.IO) {
                    try {
                        setWorkoutScheduleUseCase("title")
                    } catch (e: Exception) {
                        _state.value = state.value.copy(exception = e.message.toString())
                    }
                }
            }
        }
    }
}