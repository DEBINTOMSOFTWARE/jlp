package com.example.jlp.di

import com.example.jlp.data.repository.DishwasherRepository
import com.example.jlp.data.repository.DishwasherRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindDishwasherRepository(
        dishwasherRepositoryImpl: DishwasherRepositoryImpl
    ): DishwasherRepository
}