package com.sousa.bruno.androidkotlinstarter.domain.repository


import com.sousa.bruno.androidkotlinstarter.domain.model.Person
import kotlinx.coroutines.flow.Flow

interface PeopleRepository {
    // Agora recebe page e limit
    suspend fun getPeople(page: Int = 1, limit: Int = 25): List<Person>

    // Adicione a nova função aqui
    suspend fun loadNextPage(): List<Person>

    fun getFavorites(): Flow<List<Person>>

    suspend fun toggleFavorite(person: Person)
}
