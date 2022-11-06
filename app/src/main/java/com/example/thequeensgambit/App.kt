package com.example.thequeensgambit

import android.app.Application
import com.example.features.di.featuresModule
import com.example.common.di.navigationModule
import com.example.thequeensgambit.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@App)
            modules(appModule, featuresModule, navigationModule)
        }
    }
}