package com.example.proff.feature_app.data.repository

import com.example.proff.feature_app.data.network.Supabase.client
import com.example.proff.feature_app.domain.model.CategoryData
import com.example.proff.feature_app.domain.repository.MealRepository
import io.github.jan.supabase.postgrest.postgrest

class MealRepositoryImpl : MealRepository {
    override suspend fun getCategories(): List<CategoryData> {
        return client.postgrest["CategoryBreakfast"].select {

        }.decodeList<CategoryData>()
    }
}