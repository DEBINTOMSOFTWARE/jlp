package com.example.jlp.di

import com.example.jlp.domain.usecases.GetDishwashersUseCase
import com.example.jlp.domain.usecases.GetDishwashersUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class UseCaseModule {

    @Binds
    @Singleton
    abstract fun bindGetDishwashersUseCase(
        getDishwashersUseCaseImpl: GetDishwashersUseCaseImpl
    ): GetDishwashersUseCase
}