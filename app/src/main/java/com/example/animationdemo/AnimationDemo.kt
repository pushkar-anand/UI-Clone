package com.example.animationdemo

import android.app.Application
import com.example.animationdemo.di.AppComponent
import com.example.animationdemo.di.DaggerAppComponent

open class AnimationDemo : Application() {
    val appComponent: AppComponent by lazy {
        DaggerAppComponent.factory().create(this)
    }
}