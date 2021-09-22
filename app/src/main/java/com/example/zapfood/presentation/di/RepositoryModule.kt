package com.example.zapfood.presentation.di

import com.example.zapfood.data.repository.RepositoryImpl
import com.example.zapfood.data.repository.datasource.RemoteDataSource
import com.example.zapfood.domain.repository.Repository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Singleton
    @Provides
    fun providesRepository(remoteDataSource: RemoteDataSource): Repository {
        return RepositoryImpl(remoteDataSource)
    }
}