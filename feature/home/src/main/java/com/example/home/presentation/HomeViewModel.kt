package com.example.home.presentation

import com.example.home.domain.intereraction.GetRecipesUseCase
import com.example.home.domain.model.Recipe
import com.example.home.domain.repository.RecipesRepository
import com.sample.core.domain.model.onFailure
import com.sample.core.domain.model.onSuccess
import com.sample.core.presentation.base.BaseAction
import com.sample.core.presentation.base.BaseViewState
import com.sample.core.presentation.base.BaseViewModel
import javax.inject.Inject

class HomeViewModel @Inject constructor(
    val repository: RecipesRepository,
    val getRecipesUseCase: GetRecipesUseCase
) : BaseViewModel<HomeViewModel.ViewState, HomeViewModel.Action>(ViewState()) {

    sealed class Action : BaseAction {
        class RecipesListLoadingSuccess(val recipes: List<Recipe>) : Action()
        class SearchListLoadingSuccess(val recipes: List<Recipe>) : Action()
        object RecipesListLoadingFailure : Action()
        object RecipesListLoading : Action()
    }

    data class ViewState(
        val isError: Boolean = false,
        val isLoading: Boolean = false,
        val recipesList: List<Recipe> = listOf(),
        val copyRecipesList: List<Recipe> = listOf()
    ) : BaseViewState

    override fun onReduceState(viewAction: Action): ViewState = when (viewAction) {
        is Action.RecipesListLoading -> state.copy(
            isLoading = true,
            isError = false,
            recipesList = listOf(),
            copyRecipesList = listOf()
        )
        is Action.RecipesListLoadingFailure -> state.copy(
            isLoading = false,
            isError = true,
            recipesList = listOf()
        )
        is Action.RecipesListLoadingSuccess -> state.copy(
            isLoading = false,
            isError = false,
            recipesList = viewAction.recipes,
            copyRecipesList = viewAction.recipes
        )
        is Action.SearchListLoadingSuccess -> state.copy(
            isLoading = false,
            isError = false,
            recipesList = viewAction.recipes
        )
    }

    override fun onLoadData() {
        getRecipes()
    }

    private fun getRecipes() {
        sendAction(Action.RecipesListLoading)
        executeUseCase {
            getRecipesUseCase().onSuccess {
                sendAction(Action.RecipesListLoadingSuccess(it))
                println("we have the data $it")
            }.onFailure {
                sendAction(Action.RecipesListLoadingFailure)
            }
        }

    }

    fun searchItems(query : String){
        sendAction(Action.SearchListLoadingSuccess(stateLiveData.value?.copyRecipesList?.filter {  it.title.contains(query)} ?: listOf()))
    }


}