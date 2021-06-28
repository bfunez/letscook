package com.sample.letscook.presentation

import android.os.Bundle
import com.sample.core.di.component.CoreComponent
import com.sample.core.presentation.base.BaseActivity
import com.sample.letscook.LetsCookApp
import com.sample.letscook.R

class MainActivity : BaseActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.AppTheme)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
    }

    override fun getBaseComponent(): CoreComponent? {
        return LetsCookApp.coreComponent(applicationContext)
    }
}