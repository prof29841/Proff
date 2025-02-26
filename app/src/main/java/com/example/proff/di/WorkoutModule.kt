package com.example.proff.di

import com.example.proff.feature_app.data.repository.WorkoutRepositoryImpl
import com.example.proff.feature_app.domain.repository.WorkoutRepository
import com.example.proff.feature_app.domain.usecase.Workout.ChangeEnabledToUserWorkoutTrackerUseCase
import com.example.proff.feature_app.domain.usecase.Workout.GetAllWorkoutDetailsUseCase
import com.example.proff.feature_app.domain.usecase.Workout.GetAllWorkoutsUseCase
import com.example.proff.feature_app.domain.usecase.Workout.GetSomeWorkoutDetailsUseCase
import com.example.proff.feature_app.domain.usecase.Workout.GetUserWorkoutTrackersUseCase
import com.example.proff.feature_app.domain.usecase.Workout.GetWorkoutScheduleUseCase
import com.example.proff.feature_app.domain.usecase.Workout.SetWorkoutScheduleUseCase
import org.koin.dsl.module

val moduleWorkout = module {

    single<WorkoutRepository> {
        WorkoutRepositoryImpl()
    }
    factory<GetAllWorkoutDetailsUseCase> {
        GetAllWorkoutDetailsUseCase(get())
    }
    factory<GetAllWorkoutsUseCase> {
        GetAllWorkoutsUseCase(get())
    }
    factory<GetSomeWorkoutDetailsUseCase> {
        GetSomeWorkoutDetailsUseCase(get())
    }
    factory<GetUserWorkoutTrackersUseCase> {
        GetUserWorkoutTrackersUseCase(get())
    }
    factory<GetWorkoutScheduleUseCase> {
        GetWorkoutScheduleUseCase(get())
    }
    factory<SetWorkoutScheduleUseCase> {
        SetWorkoutScheduleUseCase(get())
    }
    factory<ChangeEnabledToUserWorkoutTrackerUseCase> {
        ChangeEnabledToUserWorkoutTrackerUseCase(get())
    }
}