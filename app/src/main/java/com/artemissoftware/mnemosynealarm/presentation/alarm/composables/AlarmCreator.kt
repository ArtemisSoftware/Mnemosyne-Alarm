package com.artemissoftware.mnemosynealarm.presentation.alarm.composables

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun AlarmCreator(
    secondsToTriggerAlarm: String,
    onSecondsToTriggerAlarmValueChange: (String) -> Unit,
    message: String,
    onMessageValueChange: (String) -> Unit,
    onCreateAlarm: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(12.dp),
    ) {
        OutlinedTextField(
            value = secondsToTriggerAlarm,
            onValueChange = onSecondsToTriggerAlarmValueChange,
            modifier = Modifier.fillMaxWidth(),
            placeholder = {
                Text(text = "Trigger alarm in seconds")
            },
        )
        OutlinedTextField(
            value = message,
            onValueChange = onMessageValueChange,
            modifier = Modifier.fillMaxWidth(),
            placeholder = {
                Text(text = "Message")
            },
        )
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
        ) {
            Button(
                onClick = onCreateAlarm,
            ) {
                Text(text = "Schedule")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun AlarmCreatorPreview() {
    AlarmCreator(
        secondsToTriggerAlarm = "12",
        message = "Message",
        onSecondsToTriggerAlarmValueChange = {},
        onMessageValueChange = {},
        onCreateAlarm = {},
    )
}
