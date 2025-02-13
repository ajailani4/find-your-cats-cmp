package com.ajailani.findyourcatscmp.di

import android.content.Context
import com.ajailani.findyourcatscmp.di.module.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

actual class KoinInitializer(
    private val context: Context
) {
    actual fun init() {
        startKoin {
            androidLogger()
            androidContext(context)
            modules(appModule)
        }
    }
}