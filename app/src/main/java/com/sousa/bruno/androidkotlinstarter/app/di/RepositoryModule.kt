package com.sousa.bruno.androidkotlinstarter.app.di

import com.sousa.bruno.androidkotlinstarter.core.database.PeopleDao
import com.sousa.bruno.androidkotlinstarter.core.network.ApiService
import com.sousa.bruno.androidkotlinstarter.data.local.LocalDataSource
import com.sousa.bruno.androidkotlinstarter.data.remote.RemoteDataSource
import com.sousa.bruno.androidkotlinstarter.data.repository.PeopleRepositoryImpl
import com.sousa.bruno.androidkotlinstarter.domain.repository.PeopleRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    fun provideRemoteDataSource(api: ApiService): RemoteDataSource =
        RemoteDataSource(api)

    @Provides
    @Singleton
    fun provideLocalDataSource(dao: PeopleDao): LocalDataSource =
        LocalDataSource(dao)

    @Provides
    @Singleton
    fun providePeopleRepository(
        remote: RemoteDataSource,
        local: LocalDataSource
    ): PeopleRepository =
        PeopleRepositoryImpl(remote, local)
}
