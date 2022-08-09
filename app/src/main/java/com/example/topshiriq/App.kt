package com.example.topshiriq

import android.support.multidex.MultiDex
import android.support.multidex.MultiDexApplication
import com.example.topshiriq.db.AppDatabase

class App: MultiDexApplication() {
    override fun onCreate() {
        super.onCreate()
        MultiDex.install(this)
        AppDatabase.ininDatabase(this)
    }
}