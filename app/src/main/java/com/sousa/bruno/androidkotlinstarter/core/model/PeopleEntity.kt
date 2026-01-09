package com.sousa.bruno.androidkotlinstarter.core.model

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Domain Model
 * Sempre simples, sem dependências de framework.
 */
@Entity(tableName = "people")
data class PeopleEntity(
    @PrimaryKey val id: Int,
    val firstName: String,
    val lastName: String,
    val age: Int
)