package com.danntrp.fixtures.google.ui.view

data class NotificationPayload(
    val app_id: String,
    val contents: Map<String, String>,
    val included_segments: List<String>
)
