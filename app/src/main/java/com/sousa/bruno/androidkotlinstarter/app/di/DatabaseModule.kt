package com.sousa.bruno.androidkotlinstarter.app.di

import android.content.Context
import androidx.room.Room
import com.sousa.bruno.androidkotlinstarter.core.database.AppDatabase
import com.sousa.bruno.androidkotlinstarter.core.database.PeopleDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): AppDatabase =
        Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "app_db"
        ).build()

    @Provides
    @Singleton
    fun providePeopleDao(db: AppDatabase): PeopleDao = db.peopleDao()
}
