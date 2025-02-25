package com.example.proff.di

import com.example.proff.feature_app.data.repository.UserRepositoryImpl
import com.example.proff.feature_app.domain.repository.UserRepository
import com.example.proff.feature_app.domain.usecase.User.GetHeartRateUseCase
import com.example.proff.feature_app.domain.usecase.User.GetLastActivityUseCase
import com.example.proff.feature_app.domain.usecase.User.GetNotificationsUseCase
import com.example.proff.feature_app.domain.usecase.User.GetUserDataUseCase
import com.example.proff.feature_app.domain.usecase.User.SetUserImageUseCase
import org.koin.dsl.module

val moduleUser = module {

    single<UserRepository> {
        UserRepositoryImpl()
    }
    factory<GetHeartRateUseCase> {
        GetHeartRateUseCase(get())
    }
    factory<GetLastActivityUseCase> {
        GetLastActivityUseCase(get())
    }
    factory<GetNotificationsUseCase> {
        GetNotificationsUseCase(get())
    }
    factory<GetUserDataUseCase> {
        GetUserDataUseCase(get())
    }
    factory<SetUserImageUseCase> {
        SetUserImageUseCase(get())
    }
}