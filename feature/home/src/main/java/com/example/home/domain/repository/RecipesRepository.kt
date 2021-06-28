package com.example.home.domain.repository

import com.example.home.domain.model.Recipe
import com.sample.core.domain.model.Resource

interface RecipesRepository {
    suspend fun getRecipes() : Resource<List<Recipe>>
}