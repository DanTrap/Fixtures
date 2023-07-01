package com.danntrp.fixtures.google.data.model

data class NotificationPayload(
    val app_id: String,
    val contents: Map<String, String>,
    val included_segments: List<String>
)
