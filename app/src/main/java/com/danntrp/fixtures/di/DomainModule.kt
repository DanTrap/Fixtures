package com.danntrp.fixtures.di

import com.danntrp.fixtures.fixtures.domain.repository.FixturesRepository
import com.danntrp.fixtures.fixtures.domain.usecases.FixturesByDateUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DomainModule {

    @Provides
    @Singleton
    fun provideFixturesUseCase(fixturesRepository: FixturesRepository): FixturesByDateUseCase {
        return FixturesByDateUseCase(fixturesRepository)
    }
}