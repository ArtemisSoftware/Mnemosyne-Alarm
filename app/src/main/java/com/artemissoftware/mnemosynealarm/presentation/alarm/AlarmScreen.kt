package com.artemissoftware.mnemosynealarm.presentation.alarm

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.artemissoftware.mnemosynealarm.presentation.alarm.composables.Alarm
import com.artemissoftware.mnemosynealarm.presentation.alarm.composables.AlarmCreator

@Composable
fun AlarmScreen(viewModel: AlarmViewModel = hiltViewModel()) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
    ) {
        AlarmCreator(
            secondsToTriggerAlarm = viewModel.secondsToTriggerAlarm.value,
            onSecondsToTriggerAlarmValueChange = {
                viewModel.secondsToTriggerAlarm.value = it
            },
            message = viewModel.message.value,
            onMessageValueChange = {
                viewModel.message.value = it
            },
            onCreateAlarm = {
                viewModel.onTriggerEvent(AlarmEvents.Create)
            },
        )

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(12.dp),
            content = {
                items(viewModel.alarms.value) { alarm ->
                    Alarm(
                        alarmItem = alarm,
                        onCancelClick = {
                            viewModel.onTriggerEvent(AlarmEvents.CancelAlarm(alarm))
                        },
                        modifier = Modifier.fillMaxWidth(),
                    )
                }
            },
        )
    }
}
