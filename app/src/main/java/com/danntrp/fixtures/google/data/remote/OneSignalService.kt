package com.danntrp.fixtures.google.data.remote

import com.danntrp.fixtures.google.data.model.NotificationPayload
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface OneSignalService {
    @Headers(
        "accept: application/json",
        "content-type: application/json",
        "Authorization: Basic MGRhOWUyMTAtYjMwYy00ODI3LWIwY2YtYjdjOTZiOTc4OWJj"
    )
    @POST("notifications")
    fun postNotification(@Body payload: NotificationPayload): Call<Any>
}