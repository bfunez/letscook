package com.sample.core.presentation.base

import androidx.appcompat.app.AppCompatActivity
import com.sample.core.di.component.CoreComponent

abstract class BaseActivity : AppCompatActivity() {
    abstract fun getBaseComponent() : CoreComponent?
}