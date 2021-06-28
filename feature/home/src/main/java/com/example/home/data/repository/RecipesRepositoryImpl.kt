package com.example.home.data.repository

import com.example.home.data.GetRecipesApi
import com.example.home.domain.model.Recipe
import com.example.home.domain.repository.RecipesRepository
import com.sample.core.data.CoroutineContextProvider
import com.sample.core.data.network.BaseRepo
import com.sample.core.data.network.getData
import com.sample.core.domain.model.Resource

class RecipesRepositoryImpl(
    private val coroutineContext: CoroutineContextProvider,
    private val recipesApi: GetRecipesApi
) : BaseRepo(coroutineContext), RecipesRepository{

    override suspend fun getRecipes(): Resource<List<Recipe>> = fetchData {
        recipesApi.getOrders().getData()
    }
}