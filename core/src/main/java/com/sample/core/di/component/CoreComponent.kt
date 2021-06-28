package com.sample.core.di.component

import android.content.Context
import com.sample.core.di.module.ContextModule
import com.sample.core.di.module.NetworkModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        ContextModule::class,
        NetworkModule::class
    ]
)
interface CoreComponent {
    fun context() : Context
}