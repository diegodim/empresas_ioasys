package com.diego.duarte.di

import com.diego.duarte.data.repository.AuthRepositoryImpl
import com.diego.duarte.data.repository.EnterpriseRepositoryImpl
import com.diego.duarte.domain.repository.AuthRepository
import com.diego.duarte.domain.repository.EnterpriseRepository
import org.koin.dsl.module

val dataModule = module {

    single<AuthRepository> { AuthRepositoryImpl(get(), get()) }
    single<EnterpriseRepository> { EnterpriseRepositoryImpl(get()) }
}
