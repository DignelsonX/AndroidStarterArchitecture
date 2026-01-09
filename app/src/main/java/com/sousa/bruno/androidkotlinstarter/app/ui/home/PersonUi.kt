package com.sousa.bruno.androidkotlinstarter.app.ui.home

import com.sousa.bruno.androidkotlinstarter.domain.model.Person

data class PersonUi(
    val id: Int,
    val name: String,
    val age: Int,
    val isFavorite: Boolean
) {
    fun toDomain(): Person = Person(
        id = id,
        name = name,
        age = age,
        isFavorite = isFavorite
    )
}

fun Person.toUi(): PersonUi = PersonUi(
    id = id,
    name = name,
    age = age,
    isFavorite = isFavorite
)


