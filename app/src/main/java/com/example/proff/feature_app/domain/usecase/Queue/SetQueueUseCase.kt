package com.example.proff.feature_app.domain.usecase.Queue

import com.example.proff.feature_app.domain.manger.QueueManger

class SetQueueUseCase(
    private val queueManger: QueueManger
) {
    operator fun invoke(value: Int){
        queueManger.setQueue(value)
    }
}