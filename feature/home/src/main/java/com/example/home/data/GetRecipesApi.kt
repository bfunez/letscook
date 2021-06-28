package com.example.home.data

import com.example.home.domain.model.Recipe
import retrofit2.Response
import retrofit2.http.GET

interface GetRecipesApi {
    @GET("/recipes")
    suspend fun getOrders(): Response<List<Recipe>>
}