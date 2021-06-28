package com.example.home.di.component

import com.example.home.data.GetRecipesApi
import com.sample.core.di.component.CoreComponent
import com.example.home.di.module.HomeModule
import com.example.home.di.module.RepositoryModule
import com.example.home.di.module.UseCasesModule
import com.example.home.di.scope.HomeScope
import com.example.home.domain.repository.RecipesRepository
import com.example.home.presentation.HomeFragment
import com.sample.core.di.module.NetworkModule
import dagger.Component

@HomeScope
@Component(
    dependencies = [CoreComponent::class],
    modules = [
        NetworkModule::class,
        RepositoryModule::class,
        UseCasesModule::class,
        HomeModule::class])
interface HomeComponent {
    fun inject(fragment: HomeFragment)

    /**
     * Provide dependency graph UpdateNotesApi
     *
     * @return UpdateNotesApi
     */
    fun getRecipesApi(): GetRecipesApi

    /**
     * Provide dependency graph notes
     *
     * @return UpdateNotesRepository
     */
    fun recipesRepository(): RecipesRepository
}