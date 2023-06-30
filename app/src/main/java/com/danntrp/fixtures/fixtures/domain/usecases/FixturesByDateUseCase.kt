package com.danntrp.fixtures.fixtures.domain.usecases

import com.danntrp.fixtures.fixtures.domain.repository.FixturesRepository

class FixturesByDateUseCase(
    private val repository: FixturesRepository
) {
    suspend fun invoke(fromDate: String, toDate: String) =
        repository.fixturesByDate(fromDate, toDate)
}