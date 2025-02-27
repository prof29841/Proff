package com.example.proff.feature_app.presentation.Comparison

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class ComparisonViewModel : ViewModel() {

    private val _state = mutableStateOf(ComparisonState())
    val state: State<ComparisonState> = _state

    fun onEvent(event: ComparisonEvent){
        when (event){
            ComparisonEvent.ResetException -> {
                _state.value = state.value.copy(exception = "")
            }
            is ComparisonEvent.SelectFirstMonth -> {
                _state.value = state.value.copy(firstMonth = event.value)
            }
            is ComparisonEvent.SelectSecondMonth -> {
                _state.value = state.value.copy(secondMonth = event.value)
            }
        }
    }
}