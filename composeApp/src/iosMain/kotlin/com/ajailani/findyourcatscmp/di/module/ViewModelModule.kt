package com.ajailani.findyourcatscmp.di.module

import com.ajailani.findyourcatscmp.ui.screen.cat_detail.CatDetailViewModel
import com.ajailani.findyourcatscmp.ui.screen.cat_list.CatListViewModel
import org.koin.dsl.module

actual val viewModelModule = module {
    single { CatListViewModel(get()) }
    single { CatDetailViewModel(get(), get()) }
}