package com.example.proff.feature_app.presentation.ProgressPhoto

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.proff.feature_app.domain.usecase.Photo.GetPhotosUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ProgressPhotoViewModel(
    private val getPhotosUseCase: GetPhotosUseCase
) : ViewModel() {

    private val _state = mutableStateOf(ProgressPhotoState())
    val state: State<ProgressPhotoState> = _state

    init {
        viewModelScope.launch(Dispatchers.IO) {
            _state.value = state.value.copy(showIndicator = true)
            try {
                getPhotos()
            } catch (e: Exception) {
                _state.value = state.value.copy(exception = e.message.toString())
            }
            _state.value = state.value.copy(showIndicator = false)
        }
    }

    private suspend fun getPhotos() {
        val photos = getPhotosUseCase()

        withContext(Dispatchers.Main){
            _state.value = state.value.copy(
                photos = photos
            )
        }
    }

    fun onEvent(event: ProgressPhotoEvent){
        when (event){
            ProgressPhotoEvent.ResetException -> {

                _state.value = state.value.copy(exception = "")
            }
        }
    }
}