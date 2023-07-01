package com.danntrp.fixtures.fixtures.domain.model

data class Fixture(
    val matchId: String,
    val matchDate: String,
    val homeTeamName: String,
    val homeTeamBadge: String,
    val homeTeamScore: String,
    val awayTeamName: String,
    val awayTeamScore: String,
    val awayTeamBadge: String
)