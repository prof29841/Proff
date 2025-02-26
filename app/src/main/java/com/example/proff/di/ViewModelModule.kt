package com.example.proff.di

import com.example.proff.feature_app.presentation.ChoosingGoal.ChoosingGoalViewModel
import com.example.proff.feature_app.presentation.CreatingProfile.CreatingProfileViewModel
import com.example.proff.feature_app.presentation.Home.HomeViewModel
import com.example.proff.feature_app.presentation.Notification.NotificationViewModel
import com.example.proff.feature_app.presentation.OnBoard.OnBoardViewModel
import com.example.proff.feature_app.presentation.SignIn.SignInViewModel
import com.example.proff.feature_app.presentation.SignUp.SignUpViewModel
import com.example.proff.feature_app.presentation.SuccessRegistration.SuccessRegistrationViewModel
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
}