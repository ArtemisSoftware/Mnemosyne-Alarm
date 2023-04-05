package com.artemissoftware.mnemosynealarm.domain.alarm

import com.artemissoftware.mnemosynealarm.domain.model.AlarmItem

interface AlarmScheduler {
    fun schedule(item: AlarmItem)
    fun cancel(item: AlarmItem)
}
