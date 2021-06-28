package com.example.home.di.module

import com.example.home.domain.intereraction.GetRecipesUseCase
import com.example.home.domain.intereraction.GetRecipesUseCaseImpl
import com.example.home.domain.repository.RecipesRepository
import com.example.home.di.scope.HomeScope
import dagger.Module
import dagger.Provides

@Module
class UseCasesModule {
    @Provides
    @HomeScope
    fun getRecipesUseCase( recipesRepository: RecipesRepository) : GetRecipesUseCase = GetRecipesUseCaseImpl(recipesRepository)
}