package com.artemissoftware.mnemosynealarm.domain.model

import java.time.LocalDateTime
import java.util.UUID

data class AlarmItem(
    val id: String = UUID.randomUUID().toString(),
    val time: LocalDateTime,
    val message: String,
)
