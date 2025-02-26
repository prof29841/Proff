package com.example.proff.feature_app.presentation.CategoryBreakfast

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.proff.feature_app.domain.usecase.Meal.GetCategoriesUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class CategoryBreakfastViewModel(
    private val getCategoriesUseCase: GetCategoriesUseCase
) : ViewModel() {

    private val _state = mutableStateOf(CategoryBreakfastState())
    val state: State<CategoryBreakfastState> = _state

    init {
        viewModelScope.launch(Dispatchers.IO) {
            _state.value = state.value.copy(showIndicator = true)
            try {
                getCategories()
            } catch (e: Exception) {
                _state.value = state.value.copy(exception = e.message.toString())
            }
            _state.value = state.value.copy(showIndicator = false)
        }
    }

    private suspend fun getCategories() {
        val categories = getCategoriesUseCase()

        withContext(Dispatchers.Main){
            _state.value= state.value.copy(categories = categories)
        }
    }

    fun onEvent(event: CategoryBreakfastEvent){
        when(event){
            CategoryBreakfastEvent.ResetException -> {
                _state.value = state.value.copy(exception = "'")
            }
        }
    }
}