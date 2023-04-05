package com.artemissoftware.mnemosynealarm.data.alarm

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.artemissoftware.mnemosynealarm.domain.alarm.AlarmScheduler
import com.artemissoftware.mnemosynealarm.domain.model.AlarmItem
import java.time.ZoneId
import javax.inject.Inject

class AlarmSchedulerImpl @Inject constructor(
    private val context: Context,
    private val alarmManager: AlarmManager,
) : AlarmScheduler {

    override fun schedule(item: AlarmItem) {
        alarmManager.setExactAndAllowWhileIdle(
            AlarmManager.RTC_WAKEUP,
            item.time.atZone(ZoneId.systemDefault()).toEpochSecond() * 1000,
            PendingIntent.getBroadcast(
                context,
                item.hashCode(),
                getIntent(item),
                PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE,
            ),
        )
    }

    private fun getIntent(item: AlarmItem): Intent {
        val intent = Intent(context, AlarmReceiver::class.java)
        val bundle = Bundle().apply {
            putString(ID, item.id)
            putString(MESSAGE, item.message)
        }
        return intent.apply {
            putExtras(bundle)
        }
    }

    override fun cancel(item: AlarmItem) {
        alarmManager.cancel(
            PendingIntent.getBroadcast(
                context,
                item.hashCode(),
                Intent(context, AlarmReceiver::class.java),
                PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE,
            ),
        )
    }

    companion object {
        const val ID = "ID"
        const val MESSAGE = "MESSAGE"
    }
}
