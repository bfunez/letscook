package com.sample.core.presentation.base

import androidx.lifecycle.MutableLiveData
import kotlin.properties.Delegates
import androidx.lifecycle.ViewModel
import com.sample.core.presentation.extension.launch
import com.sample.core.presentation.extension.asLiveData

abstract class BaseViewModel<ViewState : BaseViewState, ViewAction : BaseAction>(initialState: ViewState) :
    ViewModel() {

    private val stateMutableLiveData = MutableLiveData<ViewState>()
    val stateLiveData = stateMutableLiveData.asLiveData()

    protected var state by Delegates.observable(initialState) { _, _, new ->
        stateMutableLiveData.postValue(new)
    }

    fun sendAction(viewAction: ViewAction) {
        state = onReduceState(viewAction)
    }

    fun loadData() {
        onLoadData()
    }

    protected open fun onLoadData() {}

    protected abstract fun onReduceState(viewAction: ViewAction): ViewState

    protected fun executeUseCase(action: suspend () -> Unit) {
        launch { action() }
    }



}