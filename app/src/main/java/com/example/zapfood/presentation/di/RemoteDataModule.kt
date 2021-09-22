package com.example.zapfood.presentation.di

import com.example.zapfood.data.api.APIService
import com.example.zapfood.data.repository.datasource.RemoteDataSource
import com.example.zapfood.data.repository.datasourceImpl.RemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RemoteDataModule {

    @Singleton
    @Provides
    fun provideRemoteDataSource(apiService: APIService): RemoteDataSource {
        return RemoteDataSourceImpl(apiService)
    }
}