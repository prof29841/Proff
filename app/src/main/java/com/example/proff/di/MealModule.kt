package com.example.proff.di

import com.example.proff.feature_app.data.repository.MealRepositoryImpl
import com.example.proff.feature_app.domain.repository.MealRepository
import com.example.proff.feature_app.domain.usecase.Meal.GetCategoriesUseCase
import org.koin.dsl.module

val moduleMeal = module {

    single<MealRepository> {
        MealRepositoryImpl()
    }
    factory<GetCategoriesUseCase> {
        GetCategoriesUseCase(get())
    }
}