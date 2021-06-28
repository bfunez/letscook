package com.example.home.domain.intereraction

import com.example.home.domain.model.Recipe
import com.sample.core.domain.model.Resource

interface GetRecipesUseCase {
    suspend operator fun invoke() : Resource<List<Recipe>>
}