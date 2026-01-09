package com.sousa.bruno.androidkotlinstarter.core.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "people")
data class PersonEntity(
    @PrimaryKey val id: Int
)
