package com.danntrp.fixtures.fixtures.domain.mappers

import com.danntrp.fixtures.fixtures.data.model.FixtureDto
import com.danntrp.fixtures.fixtures.domain.model.Fixture

class MapperFixtureDtoToDomain : FixtureDto.Mapper<Fixture> {
    override fun map(fixtureDto: FixtureDto): Fixture {
        return with(fixtureDto) {
            Fixture(
                matchId = match_id,
                matchDate = match_date,
                homeTeamName = match_hometeam_name,
                homeTeamBadge = team_home_badge,
                homeTeamScore = match_hometeam_score,
                awayTeamName = match_awayteam_name,
                awayTeamBadge = team_away_badge,
                awayTeamScore = match_awayteam_score
            )
        }
    }
}