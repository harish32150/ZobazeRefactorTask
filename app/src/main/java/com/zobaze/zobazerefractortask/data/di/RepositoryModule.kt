package com.zobaze.zobazerefractortask.data.di

import com.zobaze.zobazerefractortask.data.repository.EmployeeRepositoryImpl
import com.zobaze.zobazerefractortask.domain.repository.EmployeeRepository
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
    abstract fun bindEmployeeRepository(impl: EmployeeRepositoryImpl): EmployeeRepository
}