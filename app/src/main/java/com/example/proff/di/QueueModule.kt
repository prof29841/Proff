package com.example.proff.di

import com.example.proff.feature_app.data.manger.QueueMangerImpl
import com.example.proff.feature_app.domain.manger.QueueManger
import com.example.proff.feature_app.domain.usecase.Queue.GetQueueUseCase
import com.example.proff.feature_app.domain.usecase.Queue.SetQueueUseCase
import org.koin.dsl.module

val moduleQueue = module {

    single<QueueManger> {
        QueueMangerImpl(get())
    }
    factory<GetQueueUseCase> {
        GetQueueUseCase(get())
    }
    factory<SetQueueUseCase> {
        SetQueueUseCase(get())
    }
}