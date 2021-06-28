package com.sample.letscook.di.component

import com.sample.core.di.component.CoreComponent
import com.sample.letscook.LetsCookApp
import com.sample.letscook.di.module.AppModule
import com.sample.letscook.di.scope.AppScope
import dagger.Component

@AppScope
@Component(
    dependencies = [CoreComponent::class],
    modules = [AppModule::class]
)
interface AppComponent {
    fun inject(application : LetsCookApp)
}