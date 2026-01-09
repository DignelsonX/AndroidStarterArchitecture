package com.sousa.bruno.androidkotlinstarter.core.network

import com.sousa.bruno.androidkotlinstarter.core.model.PeopleEntity
import com.sousa.bruno.androidkotlinstarter.core.network.dto.PersonDto
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Interface Retrofit com endpoints.
 * Fica no core pois outras camadas podem utilizá-la.
 * Sempre retornar modelos do tipo DTO.
 */

interface ApiService {
    @GET("peoples")
    suspend fun getPeople(
        @Query("page") page: Int,
        @Query("limit") limit: Int = 25
    ): List<PersonDto>
}