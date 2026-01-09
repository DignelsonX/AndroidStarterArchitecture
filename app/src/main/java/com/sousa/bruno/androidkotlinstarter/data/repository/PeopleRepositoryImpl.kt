package com.sousa.bruno.androidkotlinstarter.data.repository

import com.sousa.bruno.androidkotlinstarter.core.database.PersonEntity
import com.sousa.bruno.androidkotlinstarter.data.local.LocalDataSource
import com.sousa.bruno.androidkotlinstarter.data.remote.RemoteDataSource
import com.sousa.bruno.androidkotlinstarter.domain.model.Person
import com.sousa.bruno.androidkotlinstarter.domain.repository.PeopleRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class PeopleRepositoryImpl @Inject constructor(
    private val remote: RemoteDataSource,
    private val local: LocalDataSource
) : PeopleRepository {

    private var currentPage = 1

    /**
     * Busca dados remotos paginados e marca aqueles que estão nos favoritos locais.
     */
    override suspend fun getPeople(page: Int, limit: Int): List<Person> {
        // busca lista remota paginada
        val remoteList = remote.getPeople(page, limit)

        // pega snapshot dos favoritos locais (Flow -> lista)
        val favoriteEntities: List<PersonEntity> = local.getFavorites().first()
        val favSet: Set<Int> = favoriteEntities.map { it.id }.toSet()

        // mapeia DTO -> Domain e marca isFavorite conforme o snapshot local
        return remoteList.map { dto ->
            Person(
                id = dto.id,
                name = "${dto.firstName} ${dto.lastName}",
                age = dto.age,
                isFavorite = favSet.contains(dto.id)
            )
        }
    }

    // Adicione a palavra-chave "override" aqui
    // Pode até remover do repositório e deixar no ViewModel
    override suspend fun loadNextPage(): List<Person> {
        throw NotImplementedError("Use getPeople(page, limit) from ViewModel instead")
    }

    /**
     * Live updates dos favoritos.
     */
    override fun getFavorites(): Flow<List<Person>> =
        local.getFavorites().map { list ->
            list.map { entity ->
                Person(
                    id = entity.id,
                    name = "", // opcional: combine com remoto se quiser nome/idade
                    age = 0,
                    isFavorite = true
                )
            }
        }

    override suspend fun toggleFavorite(person: Person) {
        local.toggleFavorite(person.id, person.isFavorite)
    }
}

