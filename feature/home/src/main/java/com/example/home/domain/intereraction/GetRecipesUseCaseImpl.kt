package com.example.home.domain.intereraction

import com.example.home.domain.model.Recipe
import com.example.home.domain.repository.RecipesRepository
import com.sample.core.domain.model.Resource

class GetRecipesUseCaseImpl ( private  val recipeRepository: RecipesRepository) : GetRecipesUseCase{
    override suspend fun invoke(): Resource<List<Recipe>> = recipeRepository.getRecipes()
}