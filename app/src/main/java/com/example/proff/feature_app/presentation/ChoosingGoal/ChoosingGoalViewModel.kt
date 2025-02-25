package com.example.proff.feature_app.presentation.ChoosingGoal

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.proff.feature_app.domain.model.UserData
import com.example.proff.feature_app.domain.usecase.Auth.SelectPurposeUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ChoosingGoalViewModel(
    private val selectPurposeUseCase: SelectPurposeUseCase
): ViewModel() {

    private val _state = mutableStateOf(ChoosingGoalState())
    val state: State<ChoosingGoalState> = _state

    fun onEvent(event: ChoosingGoalEvent){
        when (event){
            is ChoosingGoalEvent.ChooseGoal -> {
                viewModelScope.launch(Dispatchers.IO) {
                    _state.value = state.value.copy(showIndicator = true)
                    try {
                        selectPurposeUseCase(UserData("","","", purpose = event.value.title))
                        _state.value = state.value.copy(isComplete = true)
                    } catch (e: Exception) {
                        _state.value = state.value.copy(exception = e.message.toString())
                    }
                    _state.value = state.value.copy(showIndicator = false)
                }
            }
            ChoosingGoalEvent.ResetException -> {
                _state.value = state.value.copy(exception = "")
            }
        }
    }
}