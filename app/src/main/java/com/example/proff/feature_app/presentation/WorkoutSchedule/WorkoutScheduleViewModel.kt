package com.example.proff.feature_app.presentation.WorkoutSchedule

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.proff.feature_app.domain.usecase.Workout.GetWorkoutScheduleUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlinx.datetime.Clock
import java.time.LocalDate

class WorkoutScheduleViewModel(
    private val getWorkoutSchedule: GetWorkoutScheduleUseCase
) : ViewModel() {

    private val _state = mutableStateOf(WorkoutScheduleState())
    val state: State<WorkoutScheduleState> = _state

    init {
        viewModelScope.launch(Dispatchers.IO) {
            _state.value = state.value.copy(showIndicator = true)
            try {
                getSchedule()
            } catch (e: Exception) {
                _state.value = state.value.copy(exception = e.message.toString())
            }
            _state.value = state.value.copy(showIndicator = false)
        }
    }

    private suspend fun getSchedule() {
        val schedule = getWorkoutSchedule()
        withContext(Dispatchers.Main){
            _state.value = state.value.copy(
                workoutSchedule = schedule
            )
        }

        val clock = Clock.System.now().toString().dropLast(1)
        val month = LocalDate.now().month.name
        val day = LocalDate.now().dayOfMonth
        val daysCount = if (LocalDate.now().year.rem(4) == 0) LocalDate.now().month.maxLength() -1 else LocalDate.now().month.maxLength()

        _state.value = state.value.copy(
            clock = clock,
            currentMonth = month,
            currentData = day.toString(),
            daysCount = daysCount
        )
    }

    fun onEvent(event: WorkoutScheduleEvent){
        when (event){
            WorkoutScheduleEvent.ResetException -> {
                _state.value = state.value.copy(exception = "")
            }
        }
    }
}