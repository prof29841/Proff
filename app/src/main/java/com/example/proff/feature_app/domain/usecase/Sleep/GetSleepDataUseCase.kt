package com.example.proff.feature_app.domain.usecase.Sleep

import com.example.proff.feature_app.domain.model.SleepScheduleData
import com.example.proff.feature_app.domain.repository.SleepRepository

class GetSleepDataUseCase(
    private val sleepRepository: SleepRepository
) {

    suspend operator fun invoke() : List<SleepScheduleData>{
        return sleepRepository.getSleepData()
    }
}