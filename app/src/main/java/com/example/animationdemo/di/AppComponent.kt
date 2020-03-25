package com.example.animationdemo.di

import android.app.Application
import com.example.animationdemo.ui.activities.BaseActivity
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ViewModelModule::class])
interface AppComponent {

    @Component.Factory
    interface Factory {
        // With @BindsInstance, the Context passed in will be available in the graph
        fun create(@BindsInstance application: Application): AppComponent
    }

    fun inject(baseActivity: BaseActivity)
}