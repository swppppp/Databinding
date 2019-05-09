package com.example.recyclerprac.di

import com.example.recyclerprac.repo.RecentRepositoryImpl
import com.example.recyclerprac.viewmodel.RecentViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

// 데이터 주입..?ㅠㅠ
val RecentModule = module {
    factory {
        RecentRepositoryImpl()
    }
    viewModel {
        RecentViewModel(androidApplication(), get())
    }
}