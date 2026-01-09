package com.sousa.bruno.androidkotlinstarter.core.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Entity
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.PrimaryKey
import androidx.room.Query
import com.sousa.bruno.androidkotlinstarter.core.model.PeopleEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface PeopleDao {

    @Query("SELECT * FROM people")
    fun getFavorites(): Flow<List<PersonEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFavorite(person: PersonEntity)

    @Query("DELETE FROM people WHERE id = :id")
    suspend fun deleteFavorite(id: Int)

    @Query("SELECT EXISTS(SELECT 1 FROM people WHERE id = :id)")
    suspend fun isFavorite(id: Int): Boolean

    @Delete
    suspend fun removeFavorite(person: PersonEntity)
}