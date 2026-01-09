package com.sousa.bruno.androidkotlinstarter.core.database

import androidx.room.Database
import androidx.room.RoomDatabase

/**
 * Banco Room e DAOs.
 * Mantido simples e isolado.
 * Fácil de testar com Room.inMemoryDatabaseBuilder.
 */

@Database(
    entities = [PersonEntity::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun peopleDao(): PeopleDao
}
