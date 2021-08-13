package com.diego.duarte.di

import com.diego.duarte.data.SessionLocalDataSource
import com.diego.duarte.data_local.core.PreferencesHelper
import com.diego.duarte.data_local.datasource.SessionLocalDataSourceImpl
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val dataLocalModule = module {

    single { PreferencesHelper(androidApplication()) }
    single<SessionLocalDataSource> { SessionLocalDataSourceImpl(get()) }
}
