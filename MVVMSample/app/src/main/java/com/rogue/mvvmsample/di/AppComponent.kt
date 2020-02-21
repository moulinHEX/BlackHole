package com.rogue.mvvmsample.di

import android.content.Context
import com.rogue.mvvmsample.ui.home.HomeActivity
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Component(modules = [
    NetworkModule::class
])
@Singleton
interface AppComponent {
    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): AppComponent
    }

    fun inject(activity: HomeActivity)
}