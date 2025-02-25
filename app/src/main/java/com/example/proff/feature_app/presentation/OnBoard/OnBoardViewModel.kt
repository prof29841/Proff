package com.example.proff.feature_app.presentation.OnBoard

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.proff.feature_app.domain.usecase.Queue.GetQueueUseCase
import com.example.proff.feature_app.domain.usecase.Queue.SetQueueUseCase

class OnBoardViewModel(
    private val getQueueUseCase: GetQueueUseCase,
    private val setQueueUseCase: SetQueueUseCase
) : ViewModel() {

    private val _state = mutableStateOf(OnBoardState())
    val state: State<OnBoardState> = _state

    init {
        val queue = getQueueUseCase()

        if (queue == -1){
            _state.value = state.value.copy(isComplete = true)
        }else{
            _state.value = state.value.copy(currentPage = queue)
        }
    }

    fun onEvent(event: OnBoardEvent){
        when (event){
            is OnBoardEvent.NextPage -> {
                if (_state.value.list.size <= event.value){
                    setQueueUseCase(-1)
                    _state.value = state.value.copy(isComplete = true)
                }else{
                    _state.value = state.value.copy(currentPage = event.value)
                }
            }
        }
    }
}