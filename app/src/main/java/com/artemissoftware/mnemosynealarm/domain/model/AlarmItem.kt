package com.artemissoftware.mnemosynealarm.domain.model

import java.time.LocalDateTime

data class AlarmItem(
    val time: LocalDateTime,
    val message: String,
)