package com.danntrp.fixtures.fixtures.data.repository

import com.danntrp.fixtures.fixtures.core.Resource
import com.danntrp.fixtures.fixtures.data.model.FixtureDto
import com.danntrp.fixtures.fixtures.data.remote.FootballService
import com.danntrp.fixtures.fixtures.domain.model.Fixture
import com.danntrp.fixtures.fixtures.domain.repository.FixturesRepository

class FixturesRepositoryImpl(
    private val footballService: FootballService,
    private val mapper: FixtureDto.Mapper<Fixture>
) : FixturesRepository {
    override suspend fun fixturesByDate(fromDate: String, toDate: String): Resource<List<Fixture>> {
        val response = footballService.getEvents(
            fromDate = fromDate,
            toDate = toDate,
            leagueId = 175,
            apiKey = "0cf9cbe4d07d11c624144d888c41bcc36f08e4d9eb0aef122f21c8e8d6db88fd"
        )
        val body = response.body()
        return if (response.isSuccessful && body != null) {
            Resource.Success(body.map { it.map(mapper) })
        } else {
            Resource.Error(response.message())
        }
    }
}