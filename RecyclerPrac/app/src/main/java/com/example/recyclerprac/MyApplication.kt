package com.example.recyclerprac

import android.app.Application
import com.example.recyclerprac.di.RecentModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(RecentModule)
            androidContext(this@MyApplication)
        }
    }
}