package com.example.proff.feature_app.presentation.CreatingProfile

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.proff.feature_app.domain.model.UserData
import com.example.proff.feature_app.domain.usecase.Auth.CreateProfileUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CreatingProfileViewModel(
    private val createProfileUseCase: CreateProfileUseCase
) : ViewModel() {

    private val _state = mutableStateOf(CreatingProfileState())
    val state: State<CreatingProfileState> = _state

    fun onEvent(event: CreatingProfileEvent) {
        when (event) {
            is CreatingProfileEvent.BirthdayDataEnter -> {
                _state.value = state.value.copy(
                    birthdayData = event.value
                )
            }

            CreatingProfileEvent.CreateProfile -> {
                if (
                    _state.value.gender.isNotBlank() &&
                    _state.value.birthdayData.isNotBlank() &&
                    _state.value.weight.toIntOrNull() != null &&
                    _state.value.height.toIntOrNull() != null
                ) {
                    viewModelScope.launch(Dispatchers.IO) {
                        _state.value = state.value.copy(showIndicator = true)
                        try {
                            createProfileUseCase(
                                UserData(
                                    "",
                                    "",
                                    "",
                                    _state.value.gender,
                                    _state.value.birthdayData,
                                    _state.value.weight,
                                    _state.value.height
                                )
                            )
                            _state.value = state.value.copy(isComplete = true)
                        } catch (e: Exception) {
                            _state.value = state.value.copy(exception = e.message.toString())
                        }
                        _state.value = state.value.copy(showIndicator = false)
                    }
                } else {
                    _state.value = state.value.copy(exception = "some data wrong")
                }
            }

            is CreatingProfileEvent.GenderEnter -> {
                _state.value = state.value.copy(
                    gender = event.value
                )
            }

            is CreatingProfileEvent.HeightEnter -> {
                _state.value = state.value.copy(
                    height = event.value
                )
            }

            CreatingProfileEvent.ResetException -> {
                _state.value = state.value.copy(exception = "")
            }

            is CreatingProfileEvent.WeightEnter -> {
                _state.value = state.value.copy(
                    weight = event.value
                )
            }
        }
    }
}