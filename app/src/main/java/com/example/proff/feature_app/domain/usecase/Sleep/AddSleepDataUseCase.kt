package com.example.proff.feature_app.domain.usecase.Sleep

import com.example.proff.feature_app.domain.model.SleepScheduleData
import com.example.proff.feature_app.domain.repository.SleepRepository

class AddSleepDataUseCase(
    private val sleepRepository: SleepRepository
) {

    suspend operator fun invoke(sleepScheduleData: SleepScheduleData){
        sleepRepository.addSleepData(sleepScheduleData)
    }
}