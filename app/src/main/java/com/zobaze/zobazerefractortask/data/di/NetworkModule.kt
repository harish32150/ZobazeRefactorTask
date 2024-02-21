package com.zobaze.zobazerefractortask.data.di

import com.zobaze.zobazerefractortask.data.datasource.remote.EmployeeService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideEmployeeService(): EmployeeService =
        provideRetrofit("https://dummy.restapiexample.com/api")
            .create(EmployeeService::class.java)


    /** Provides [Retrofit] instance with [baseUrl] to create api service */
    private fun provideRetrofit(baseUrl: String): Retrofit =
        Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
}