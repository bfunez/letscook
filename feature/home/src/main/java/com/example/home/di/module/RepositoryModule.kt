package com.example.home.di.module

import com.example.home.data.GetRecipesApi
import com.example.home.data.repository.RecipesRepositoryImpl
import com.example.home.domain.repository.RecipesRepository
import com.sample.core.data.CoroutineContextProvider
import com.example.home.di.scope.HomeScope
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
class RepositoryModule {

    @HomeScope
    @Provides
    fun provideRecipesApi( retrofit: Retrofit ) : GetRecipesApi = retrofit.create(GetRecipesApi::class.java)

    @Provides
    @HomeScope
    fun recipesRepository(
        coroutineContext: CoroutineContextProvider,
        recipesApi: GetRecipesApi
    ): RecipesRepository = RecipesRepositoryImpl( coroutineContext,recipesApi)
}