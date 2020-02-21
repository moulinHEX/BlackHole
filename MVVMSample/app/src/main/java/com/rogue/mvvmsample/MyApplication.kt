package com.rogue.mvvmsample

import android.app.Application
import com.rogue.mvvmsample.di.DaggerAppComponent

class MyApplication: Application() {
    val appComponent = DaggerAppComponent.factory().create(this)
}