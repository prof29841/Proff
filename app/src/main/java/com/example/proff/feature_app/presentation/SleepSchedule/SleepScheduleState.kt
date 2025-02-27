package com.example.proff.feature_app.presentation.SleepSchedule

import com.example.proff.feature_app.domain.model.SleepScheduleData
import java.time.LocalDate

data class SleepScheduleState(
    val exception: String = "",
    val showIndicator: Boolean = false,

    val sleepSchedule: List<SleepScheduleData> = emptyList(),

    val dayCount: Int = if (LocalDate.now().year % 4 == 0) {
        if (LocalDate.now().month.value == 2){
            LocalDate.now().dayOfMonth - 1
        }else{
            LocalDate.now().dayOfMonth
        }
    } else {
        LocalDate.now().dayOfMonth
    },
    val currentDay: Int = LocalDate.now().dayOfMonth
)
