package com.sousa.bruno.androidkotlinstarter.data.local

import com.sousa.bruno.androidkotlinstarter.core.database.PeopleDao
import com.sousa.bruno.androidkotlinstarter.core.database.PersonEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LocalDataSource @Inject constructor(
    private val dao: PeopleDao
) {
    fun getFavorites(): Flow<List<PersonEntity>> = dao.getFavorites()

    suspend fun toggleFavorite(id: Int, isFavorite: Boolean) {
        if (isFavorite) {
            dao.removeFavorite(PersonEntity(id))
        } else {
            dao.insertFavorite(PersonEntity(id))
        }
    }
}
