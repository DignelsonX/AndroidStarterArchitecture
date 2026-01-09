package com.sousa.bruno.androidkotlinstarter.data.remote

import com.sousa.bruno.androidkotlinstarter.core.network.ApiService
import com.sousa.bruno.androidkotlinstarter.core.network.dto.PersonDto
import javax.inject.Inject


class RemoteDataSource @Inject constructor(private val api: ApiService) {
    suspend fun getPeople(page: Int = 1, limit: Int = 25) =
        api.getPeople(page = page, limit = limit)
}