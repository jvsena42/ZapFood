package com.example.zapfood.presentation.di

import com.example.zapfood.domain.repository.Repository
import com.example.zapfood.domain.usecase.GetCategoriesUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class UseCaseModule {

    @Singleton
    @Provides
    fun provideGetCategoriesUseCase(repository: Repository): GetCategoriesUseCase{
        return GetCategoriesUseCase(repository)
    }
}