package com.sousa.bruno.androidkotlinstarter.core.network.dto;

import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;

@Serializable
data class PersonDto(
        @SerialName("id") val id: Int,
        @SerialName("firstName") val firstName: String,
        @SerialName("lastName") val lastName: String,
        @SerialName("age") val age: Int
)



