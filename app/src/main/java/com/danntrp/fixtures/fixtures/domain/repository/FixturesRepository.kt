package com.danntrp.fixtures.fixtures.domain.repository

import com.danntrp.fixtures.fixtures.core.Resource
import com.danntrp.fixtures.fixtures.domain.model.Fixture

interface FixturesRepository {
    suspend fun fixturesByDate(fromDate: String, toDate: String): Resource<List<Fixture>>
}