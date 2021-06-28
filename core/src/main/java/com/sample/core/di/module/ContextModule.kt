package com.sample.core.di.module

import android.app.Application
import android.content.Context
import com.sample.core.data.CoroutineContextProvider
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ContextModule( private val application: Application){

    /**
     * Create a provider method binding for [Context].
     *
     * @return Instance of context.
     * @see Provides
     */
    @Singleton
    @Provides
    fun provideContext(): Context = application

    @Singleton
    @Provides
    fun coroutineContextProviderModule() = CoroutineContextProvider()
}