package com.example.proff.feature_app.presentation

import android.app.Application
import com.example.proff.di.moduleAuth
import com.example.proff.di.moduleQueue
import com.example.proff.di.moduleUser
import com.example.proff.di.moduleViewModel
import com.example.proff.di.moduleWorkout
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@App)
            androidLogger(Level.DEBUG)
            modules(listOf(
                moduleViewModel, moduleQueue, moduleAuth, moduleUser,
                moduleWorkout
            ))
        }
    }
}