package com.example.proff.feature_app.domain.repository

import com.example.proff.feature_app.domain.model.SleepScheduleData

interface SleepRepository {

    suspend fun getSleepData() : List<SleepScheduleData>
    suspend fun addSleepData(sleepScheduleData: SleepScheduleData)

    suspend fun changeSleepEnabled(sleepScheduleData: SleepScheduleData)
}