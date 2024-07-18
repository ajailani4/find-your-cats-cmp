package com.ajailani.findyourcatscmp

import android.app.Application
import com.ajailani.findyourcatscmp.di.KoinInitializer

class MainApp : Application() {
    override fun onCreate() {
        super.onCreate()
        KoinInitializer(applicationContext).init()
    }
}