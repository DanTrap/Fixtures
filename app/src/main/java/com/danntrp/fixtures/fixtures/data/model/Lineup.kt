package com.danntrp.fixtures.fixtures.data.model

data class Lineup(
    val starting_lineups: List<Player>,
    val substitutes: List<Player>,
    val coach: List<Player>,
    val missing_players: List<Player>
)