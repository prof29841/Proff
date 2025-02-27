package com.example.proff.feature_app.presentation.TakePhoto

import android.graphics.Bitmap
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.proff.feature_app.domain.usecase.Photo.AddPhotoUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.io.ByteArrayOutputStream

class TakePhotoViewModel(
    private val addPhotoUseCase: AddPhotoUseCase
) : ViewModel() {

    private val _state = mutableStateOf(TakePhotoState())
    val state: State<TakePhotoState> = _state

    fun onEvent(event: TakePhotoEvent){
        when (event){
            TakePhotoEvent.ResetException -> {
                _state.value = state.value.copy(exception = "")
            }
            is TakePhotoEvent.TakePhoto -> {
                val byteArray = event.bitmap.toByteArray()
                viewModelScope.launch(Dispatchers.IO) {
                    try {
                        addPhotoUseCase(byteArray)
                    } catch (e: Exception) {
                        _state.value = state.value.copy(exception = e.message.toString())
                    }
                }
            }
        }
    }

    private fun Bitmap.toByteArray() : ByteArray{
        val baos = ByteArrayOutputStream()
        this.compress(Bitmap.CompressFormat.PNG, 100, baos)
        return baos.toByteArray()
    }
}