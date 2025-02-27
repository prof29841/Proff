package com.example.proff.di

import com.example.proff.feature_app.presentation.ActivityTracker.ActivityTrackerViewModel
import com.example.proff.feature_app.presentation.AddAlarm.AddAlarmViewModel
import com.example.proff.feature_app.presentation.AddWorkoutSchedule.AddWorkoutScheduleViewModel
import com.example.proff.feature_app.presentation.CategoryBreakfast.CategoryBreakfastViewModel
import com.example.proff.feature_app.presentation.ChoosingGoal.ChoosingGoalViewModel
import com.example.proff.feature_app.presentation.Comparison.ComparisonViewModel
import com.example.proff.feature_app.presentation.CreatingProfile.CreatingProfileViewModel
import com.example.proff.feature_app.presentation.Home.HomeViewModel
import com.example.proff.feature_app.presentation.Notification.NotificationViewModel
import com.example.proff.feature_app.presentation.OnBoard.OnBoardViewModel
import com.example.proff.feature_app.presentation.Profile.ProfileViewModel
import com.example.proff.feature_app.presentation.ProgressPhoto.ProgressPhotoViewModel
import com.example.proff.feature_app.presentation.SignIn.SignInViewModel
import com.example.proff.feature_app.presentation.SignUp.SignUpViewModel
import com.example.proff.feature_app.presentation.SleepSchedule.SleepScheduleViewModel
import com.example.proff.feature_app.presentation.SleepTracker.SleepTrackerViewModel
import com.example.proff.feature_app.presentation.SuccessRegistration.SuccessRegistrationViewModel
import com.example.proff.feature_app.presentation.TakePhoto.TakePhotoViewModel
import com.example.proff.feature_app.presentation.WorkoutDetails1.WorkoutDetails1ViewModel
import com.example.proff.feature_app.presentation.WorkoutDetails2.WorkoutDetails2ViewModel
import com.example.proff.feature_app.presentation.WorkoutSchedule.WorkoutScheduleViewModel
import com.example.proff.feature_app.presentation.WorkoutTracker.WorkoutTrackerViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val moduleViewModel = module {

    viewModel<OnBoardViewModel> {
        OnBoardViewModel(get(), get())
    }

    viewModel<SignInViewModel> {
        SignInViewModel(get(), get())
    }
    viewModel<SignUpViewModel> {
        SignUpViewModel(get())
    }
    viewModel<CreatingProfileViewModel> {
        CreatingProfileViewModel(get())
    }
    viewModel<ChoosingGoalViewModel> {
        ChoosingGoalViewModel(get())
    }
    viewModel<SuccessRegistrationViewModel> {
        SuccessRegistrationViewModel(get())
    }


    viewModel<HomeViewModel> {
        HomeViewModel(get(), get())
    }
    viewModel<NotificationViewModel> {
        NotificationViewModel(get())
    }
    viewModel<ProfileViewModel> {
        ProfileViewModel(get(), get())
    }
    viewModel<ActivityTrackerViewModel> {
        ActivityTrackerViewModel(get(), get())
    }
    viewModel<WorkoutTrackerViewModel> {
        WorkoutTrackerViewModel(get(), get(), get())
    }
    viewModel<WorkoutDetails1ViewModel> {
        WorkoutDetails1ViewModel(get())
    }
    viewModel<WorkoutDetails2ViewModel> {
        WorkoutDetails2ViewModel(get())
    }
    viewModel<WorkoutScheduleViewModel> {
        WorkoutScheduleViewModel(get())
    }
    viewModel<AddWorkoutScheduleViewModel> {
        AddWorkoutScheduleViewModel(get())
    }
    viewModel<CategoryBreakfastViewModel> {
        CategoryBreakfastViewModel(get())
    }


    viewModel<SleepTrackerViewModel> {
        SleepTrackerViewModel(get(), get(), get())
    }
    viewModel<SleepScheduleViewModel>{
        SleepScheduleViewModel(get(), get())
    }
    viewModel<AddAlarmViewModel>{
        AddAlarmViewModel(get())
    }
    viewModel<ProgressPhotoViewModel>{
        ProgressPhotoViewModel(get())
    }
    viewModel<TakePhotoViewModel>{
        TakePhotoViewModel(get())
    }
    viewModel<ComparisonViewModel>{
        ComparisonViewModel()
    }
}