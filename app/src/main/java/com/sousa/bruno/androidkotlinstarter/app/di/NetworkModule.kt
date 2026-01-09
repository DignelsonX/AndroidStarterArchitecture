package com.sousa.bruno.androidkotlinstarter.app.di

import com.sousa.bruno.androidkotlinstarter.core.network.ApiService
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
    fun provideRetrofit(): Retrofit =
        Retrofit.Builder()
            .baseUrl("https://softwium.com/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    @Provides
    fun providePeopleApi(retrofit: Retrofit): ApiService =
        retrofit.create(ApiService::class.java)
}
