package com.ajailani.findyourcatscmp.di.module

import org.koin.dsl.module

val appModule = module {
    includes(
        viewModelModule,
        dataModule,
        networkModule,
    )
}