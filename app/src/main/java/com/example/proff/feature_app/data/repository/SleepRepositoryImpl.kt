package com.example.proff.feature_app.data.repository

import com.example.proff.feature_app.data.network.Supabase.client
import com.example.proff.feature_app.domain.model.SleepScheduleData
import com.example.proff.feature_app.domain.repository.SleepRepository
import io.github.jan.supabase.auth.auth
import io.github.jan.supabase.postgrest.postgrest

/**
 * Класс для работы с расписанием сна
 * @author Андреев Арсений 27.02.2025 10:56
 */
class SleepRepositoryImpl : SleepRepository {
    override suspend fun getSleepData(): List<SleepScheduleData> {
        val userID = getUserID()

        return client.postgrest["SleepTracker"].select {
            filter { eq("userID", userID) }
        }.decodeList<SleepScheduleData>()
    }

    override suspend fun addSleepData(sleepScheduleData: SleepScheduleData) {
        val userID = getUserID()

        client.postgrest["SleepTracker"].insert(mapOf(
            "userID" to userID,
            "title" to sleepScheduleData.title,
            "sleepTime" to sleepScheduleData.sleepTime,
            "enabled" to sleepScheduleData.enabled
        ))
    }

    override suspend fun changeSleepEnabled(sleepScheduleData: SleepScheduleData) {

        client.postgrest["SleepTracker"].update(mapOf(
            "enabled" to sleepScheduleData.enabled
        )) { filter { eq("id", sleepScheduleData.id) } }
    }

    private suspend fun getUserID() : String{
        client.auth.awaitInitialization()
        return client.auth.currentUserOrNull()?.id ?: ""
    }
}