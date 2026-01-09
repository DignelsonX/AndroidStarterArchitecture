package com.sousa.bruno.androidkotlinstarter.domain.usecase

import com.sousa.bruno.androidkotlinstarter.domain.model.Person
import com.sousa.bruno.androidkotlinstarter.domain.repository.PeopleRepository

import javax.inject.Inject

open class ToggleFavoriteUseCase @Inject constructor(
    private val repository: PeopleRepository
) {
    suspend operator fun invoke(person: Person) =
        repository.toggleFavorite(person)
}
