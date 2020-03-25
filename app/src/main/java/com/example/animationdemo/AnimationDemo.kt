package com.example.animationdemo

import android.app.Application
import com.example.animationdemo.di.AppComponent
import com.example.animationdemo.di.DaggerAppComponent

class AnimationDemo : Application() {

    val appComponent: AppComponent by lazy {
        initializeComponent()
    }

    private fun initializeComponent(): AppComponent {
        // Creates an instance of AppComponent using its Factory constructor
        // We pass the applicationContext that will be used as Context in the graph
        return DaggerAppComponent.factory().create(this)
    }

}