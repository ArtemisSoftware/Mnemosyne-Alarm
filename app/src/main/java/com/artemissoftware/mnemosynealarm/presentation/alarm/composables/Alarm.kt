package com.artemissoftware.mnemosynealarm.presentation.alarm.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.artemissoftware.mnemosynealarm.domain.model.AlarmItem
import java.time.LocalDateTime

@Composable
fun Alarm(
    alarmItem: AlarmItem,
    onCancelClick: (AlarmItem) -> Unit,
    modifier: Modifier = Modifier,
) {
    Card(
        elevation = 10.dp,
        modifier = modifier.padding(12.dp),
    ) {
        Column(modifier = Modifier.fillMaxWidth().padding(16.dp)) {
            Text(
                text = alarmItem.message,
                modifier = Modifier,
            )

            Button(
                modifier = Modifier.padding(top = 8.dp),
                onClick = {
                    onCancelClick.invoke(alarmItem)
                },
            ) {
                Text(text = "Cancel")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun AlarmPreview() {
    Alarm(
        alarmItem = AlarmItem(time = LocalDateTime.now(), message = "The alarm set"),
        onCancelClick = {},
    )
}
