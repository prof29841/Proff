package com.example.proff.feature_app.presentation.TakePhoto

import android.graphics.Bitmap

sealed class TakePhotoEvent {

    data object ResetException : TakePhotoEvent()
    data class TakePhoto(val bitmap: Bitmap) : TakePhotoEvent()
}