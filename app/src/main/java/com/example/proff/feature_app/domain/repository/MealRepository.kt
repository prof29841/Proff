package com.example.proff.feature_app.domain.repository

import com.example.proff.feature_app.domain.model.CategoryData

interface MealRepository {

    suspend fun getCategories() : List<CategoryData>
}