package com.diego.duarte.di


import com.diego.duarte.data.AuthRemoteDataSource
import com.diego.duarte.data_remote.core.WebServiceFactory
import com.diego.duarte.data_remote.datasource.AuthRemoteDataSourceImpl
import com.diego.duarte.data_remote.service.EnterpriseService
import com.diego.duarte.data_remote.service.LoginService
import org.koin.dsl.module


val dataRemoteModule = module {

    single { WebServiceFactory.provideOkHttpClient() }
    single<LoginService> { WebServiceFactory.createWebService(get()) }
    single<EnterpriseService> { WebServiceFactory.createWebService(get(), get()) }
    single<AuthRemoteDataSource> { AuthRemoteDataSourceImpl(get()) }

}