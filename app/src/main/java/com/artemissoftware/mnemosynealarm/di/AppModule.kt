package com.artemissoftware.mnemosynealarm.di

import android.app.AlarmManager
import android.content.Context
import com.artemissoftware.mnemosynealarm.data.alarm.AlarmSchedulerImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideAlarmManager(@ApplicationContext context: Context) = context.getSystemService(
        AlarmManager::class.java,
    )

    @Provides
    @Singleton
    fun provideAlarmScheduler(@ApplicationContext context: Context, alarmManager: AlarmManager) = AlarmSchedulerImpl(context = context, alarmManager = alarmManager)
}
