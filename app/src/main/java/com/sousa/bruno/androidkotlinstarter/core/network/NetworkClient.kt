package com.sousa.bruno.androidkotlinstarter.core.network

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Cliente Retrofit centralizado.
 * É isolado para que:
 * - Testes possam mockar
 * - Fácil trocar baseUrl
 * - Interceptors podem ser adicionados facilmente
 */
object NetworkClient {

    private val client = OkHttpClient.Builder()
        .addInterceptor { chain ->
            // Interceptor global para logs, tokens, etc
            val request = chain.request().newBuilder()
                .addHeader("Accept", "application/json")
                .build()
            chain.proceed(request)
        }
        .build()

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://softwium.com")
        .client(client)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val api: ApiService = retrofit.create(ApiService::class.java)
}
