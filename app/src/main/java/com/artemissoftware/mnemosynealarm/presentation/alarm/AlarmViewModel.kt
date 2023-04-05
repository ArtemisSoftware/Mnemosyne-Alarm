package com.artemissoftware.mnemosynealarm.presentation.alarm

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.artemissoftware.mnemosynealarm.domain.alarm.AlarmScheduler
import com.artemissoftware.mnemosynealarm.domain.model.AlarmItem
import dagger.hilt.android.HiltAndroidApp
import java.time.LocalDateTime
import javax.inject.Inject

@HiltAndroidApp
class AlarmViewModel @Inject constructor(
    private val alarmScheduler: AlarmScheduler,
) : ViewModel() {

    var secondsToTriggerAlarm = mutableStateOf("")
    var message = mutableStateOf("")
    var alarms = mutableStateOf(emptyList<AlarmItem>())

    fun onTriggerEvent(event: AlarmEvents) {
        when (event) {
            is AlarmEvents.CancelAlarm -> {
                cancelAlarm(event.alarmItem)
            }
            is AlarmEvents.Create -> {
                createAlarm()
            }
        }
    }

    private fun createAlarm() {
        if (secondsToTriggerAlarm.value.isNotBlank() && message.value.isNotBlank()) {
            val alarmItem = AlarmItem(
                time = LocalDateTime.now()
                    .plusSeconds(secondsToTriggerAlarm.value.toLong()),
                message = message.value,
            )

            alarmScheduler.schedule(alarmItem)

            secondsToTriggerAlarm.value = ""
            message.value = ""
        }
    }

    private fun cancelAlarm(alarm: AlarmItem) {
        alarmScheduler.cancel(alarm)
    }
}
