package com.danntrp.fixtures.fixtures.data.model

data class FixtureDto(
    val match_id: String,
    val country_id: String,
    val country_name: String,
    val league_id: String,
    val league_name: String,
    val match_date: String,
    val match_status: String,
    val match_time: String,
    val match_hometeam_id: String,
    val match_hometeam_name: String,
    val match_hometeam_score: String,
    val match_awayteam_name: String,
    val match_awayteam_id: String,
    val match_awayteam_score: String,
    val match_hometeam_halftime_score: String,
    val match_awayteam_halftime_score: String,
    val match_hometeam_extra_score: String,
    val match_awayteam_extra_score: String,
    val match_hometeam_penalty_score: String,
    val match_awayteam_penalty_score: String,
    val match_hometeam_ft_score: String,
    val match_awayteam_ft_score: String,
    val match_hometeam_system: String,
    val match_awayteam_system: String,
    val match_live: String,
    val match_round: String,
    val match_stadium: String,
    val match_referee: String,
    val team_home_badge: String,
    val team_away_badge: String,
    val league_logo: String,
    val country_logo: String,
    val league_year: String,
    val fk_stage_key: String,
    val stage_name: String,
    val goalscorer: List<Goalscorer>,
    val cards: List<Card>,
    val substitutions: Substitutions,
    val lineups: Lineups,
    val statistics: List<Statistic>,
    val statistics_1half: List<Statistic>
) {
    interface Mapper<T> {
        fun map(fixtureDto: FixtureDto): T
    }

    fun <T> map(mapper: Mapper<T>): T = mapper.map(this)
}