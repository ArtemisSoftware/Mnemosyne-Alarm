package com.artemissoftware.mnemosynealarm.presentation.alarm

import com.artemissoftware.mnemosynealarm.domain.model.AlarmItem

sealed class AlarmEvents {

    data class CancelAlarm(val alarmItem: AlarmItem) : AlarmEvents()

    object Create : AlarmEvents()
}
