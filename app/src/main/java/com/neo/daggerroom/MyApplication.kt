package com.neo.daggerroom

import android.app.Application
import com.neo.daggerroom.di.AppComponent
import com.neo.daggerroom.di.AppModule
import com.neo.daggerroom.di.DaggerAppComponent
import dagger.Component

class MyApplication: Application() {

    private lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(this))
            .build()
    }

    fun getAppComponent() : AppComponent{
        return appComponent
    }
}