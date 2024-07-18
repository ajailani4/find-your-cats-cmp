package com.ajailani.findyourcatscmp.di

import com.ajailani.findyourcatscmp.di.module.appModule
import org.koin.core.context.startKoin

actual class KoinInitializer {
    actual fun init() {
        startKoin {
            modules(appModule)
        }
    }
}