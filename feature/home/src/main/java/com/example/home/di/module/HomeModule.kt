package com.example.home.di.module

import com.example.home.di.scope.HomeScope
import com.example.home.domain.intereraction.GetRecipesUseCase
import com.example.home.domain.repository.RecipesRepository
import com.example.home.presentation.HomeFragment
import dagger.Module
import dagger.Provides
import com.sample.core.presentation.extension.viewModel
import com.example.home.presentation.HomeViewModel
import com.example.home.presentation.adapter.RecipesListAdapter

@Module
class HomeModule (val fragment : HomeFragment){

    @Provides
    @HomeScope
    fun provideNoteViewModel(
        repository: RecipesRepository,
        getRecipesUseCase: GetRecipesUseCase
    ) = fragment.viewModel {
        HomeViewModel(repository, getRecipesUseCase)
    }

    @HomeScope
    @Provides
    fun providesRecipesListAdapter(
        viewModel: HomeViewModel
    ) = RecipesListAdapter(viewModel)
}