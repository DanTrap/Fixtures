package com.danntrp.fixtures.fixtures.data.remote

import com.danntrp.fixtures.fixtures.data.model.FixtureDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface FootballService {
    @GET("?action=get_events")
    suspend fun getEvents(
        @Query("from") fromDate: String,
        @Query("to") toDate: String,
        @Query("league_id") leagueId: Int,
        @Query("APIkey") apiKey: String
    ): Response<List<FixtureDto>>

    companion object {
        const val BASE_URL = "https://apiv3.apifootball.com/"
    }
}