package com.sample.letscook

import android.content.Context
import com.google.android.play.core.splitcompat.SplitCompatApplication
import com.sample.core.di.component.CoreComponent
import com.sample.core.di.component.DaggerCoreComponent
import com.sample.core.di.module.ContextModule
import com.sample.letscook.di.component.DaggerAppComponent

class LetsCookApp :  SplitCompatApplication(){
    lateinit var coreComponent: CoreComponent

    companion object {
        @JvmStatic
        fun coreComponent(context: Context) = (context.applicationContext as? LetsCookApp)?.coreComponent
    }

    override fun onCreate() {
        super.onCreate()
        initDaggerDependencyInjection()
    }

    private fun initDaggerDependencyInjection() {
        coreComponent = DaggerCoreComponent
            .builder()
            .contextModule(ContextModule(this))
            .build()

        DaggerAppComponent
            .builder()
            .coreComponent(coreComponent)
            .build()
    }
}