package com.artemissoftware.mnemosynealarm.data.alarm

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent

class AlarmReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {
        val message = intent?.getStringExtra(AlarmSchedulerImpl.MESSAGE) ?: return
        println("Alarm triggered: $message")
    }
}
