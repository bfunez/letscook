package com.sample.letscook.di.module

import android.content.Context
import com.sample.letscook.LetsCookApp
import dagger.Module
import dagger.Provides

@Module
class AppModule {
    @Provides
    fun provideContext(application : LetsCookApp) : Context = application.applicationContext
}