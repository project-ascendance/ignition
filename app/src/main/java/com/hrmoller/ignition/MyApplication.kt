package com.hrmoller.ignition

import android.app.Application
import com.hrmoller.ignition.Services.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin{
            androidContext(this@MyApplication)
            modules(appModule)
        }
    }
}