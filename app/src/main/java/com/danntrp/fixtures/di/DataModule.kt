package com.danntrp.fixtures.di

import com.danntrp.fixtures.fixtures.data.model.FixtureDto
import com.danntrp.fixtures.fixtures.data.remote.FootballService
import com.danntrp.fixtures.fixtures.data.repository.FixturesRepositoryImpl
import com.danntrp.fixtures.fixtures.domain.mappers.MapperFixtureDtoToDomain
import com.danntrp.fixtures.fixtures.domain.model.Fixture
import com.danntrp.fixtures.fixtures.domain.repository.FixturesRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataModule {

    @Provides
    @Singleton
    fun provideFootballService(): FootballService {
        val retrofit = Retrofit.Builder()
            .baseUrl(FootballService.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit.create(FootballService::class.java)
    }

    @Provides
    @Singleton
    fun provideMovieRepository(
        footballService: FootballService,
        mapperFixtureDtoToDomain: FixtureDto.Mapper<Fixture>,
    ): FixturesRepository {
        return FixturesRepositoryImpl(
            footballService,
            mapperFixtureDtoToDomain
        )
    }

    @Provides
    @Singleton
    fun provideMapperDtoToDomain(): FixtureDto.Mapper<Fixture> {
        return MapperFixtureDtoToDomain()
    }
}