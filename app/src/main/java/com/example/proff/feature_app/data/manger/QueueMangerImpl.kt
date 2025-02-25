package com.example.proff.feature_app.data.manger

import android.content.Context
import android.content.Context.MODE_PRIVATE
import com.example.proff.feature_app.domain.manger.QueueManger

class QueueMangerImpl(
    private val context: Context
) : QueueManger {

    private val key = "KEY"
    private val sp = context.getSharedPreferences(key, MODE_PRIVATE)

    override fun getQueue(): Int {
        return sp.getInt(key, 0)
    }

    override fun setQueue(value: Int) {
        sp.edit().clear().putInt(key, value).apply()
    }
}