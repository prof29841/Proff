package com.example.proff.di

import com.example.proff.feature_app.data.repository.SleepRepositoryImpl
import com.example.proff.feature_app.domain.repository.SleepRepository
import com.example.proff.feature_app.domain.usecase.Sleep.AddSleepDataUseCase
import com.example.proff.feature_app.domain.usecase.Sleep.ChangeSleepEnabledUseCase
import com.example.proff.feature_app.domain.usecase.Sleep.GetSleepDataUseCase
import org.koin.dsl.module

val moduleSleep = module {

    single<SleepRepository> {
        SleepRepositoryImpl()
    }
    factory<GetSleepDataUseCase> {
        GetSleepDataUseCase(get())
    }
    factory<ChangeSleepEnabledUseCase> {
        ChangeSleepEnabledUseCase(get())
    }
    factory<AddSleepDataUseCase> {
        AddSleepDataUseCase(get())
    }
}