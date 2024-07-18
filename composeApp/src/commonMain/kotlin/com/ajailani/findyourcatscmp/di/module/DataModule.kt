package com.ajailani.findyourcatscmp.di.module

import com.ajailani.findyourcatscmp.data.remote.api_service.CatService
import com.ajailani.findyourcatscmp.data.remote.data_source.CatRemoteDataSource
import com.ajailani.findyourcatscmp.data.repository.CatRepository
import org.koin.dsl.module

val dataModule = module {
    single { CatService(get()) }
    single { CatRemoteDataSource(get()) }
    single { CatRepository(get()) }
}