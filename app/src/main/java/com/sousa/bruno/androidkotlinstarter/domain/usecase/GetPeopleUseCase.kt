package com.sousa.bruno.androidkotlinstarter.domain.usecase


import com.sousa.bruno.androidkotlinstarter.domain.model.Person
import com.sousa.bruno.androidkotlinstarter.domain.repository.PeopleRepository
import javax.inject.Inject

open class GetPeopleUseCase @Inject constructor(
    private val repository: PeopleRepository
) {
    suspend operator fun invoke(page: Int = 1, limit: Int = 25): List<Person> =
        repository.getPeople(page, limit)
}