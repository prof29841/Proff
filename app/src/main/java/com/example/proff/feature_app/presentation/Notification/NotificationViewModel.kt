package com.example.proff.feature_app.presentation.Notification

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.proff.feature_app.domain.usecase.User.GetNotificationsUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class NotificationViewModel(
    private val getNotificationsUseCase: GetNotificationsUseCase
) : ViewModel() {

    private val _state = mutableStateOf(NotificationState())
    val state: State<NotificationState> = _state

    init {
        viewModelScope.launch(Dispatchers.IO) {
            _state.value = state.value.copy(showIndicator = true)
            try {
                getNotifications()
            } catch (e: Exception) {
                _state.value = state.value.copy(exception = e.message.toString())
            }
            _state.value = state.value.copy(showIndicator = false)
        }
    }

    private suspend fun getNotifications() {
        val notifications = getNotificationsUseCase()

        withContext(Dispatchers.Main){
            _state.value = state.value.copy(notifications = notifications)
        }
    }

    fun onEvent(event: NotificationEvent){
        when (event){
            NotificationEvent.ResetException -> {
                _state.value = state.value.copy(exception = "")
            }
        }
    }
}