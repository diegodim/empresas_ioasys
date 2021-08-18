package com.diego.duarte.di


import com.diego.duarte.data.datasource.remote.AuthRemoteDataSource
import com.diego.duarte.data.datasource.remote.EnterpriseRemoteDataSource
import com.diego.duarte.data_remote.core.WebServiceFactory
import com.diego.duarte.data_remote.datasource.AuthRemoteDataSourceImpl
import com.diego.duarte.data_remote.datasource.EnterpriseRemoteDataSourceImpl
import com.diego.duarte.data_remote.service.EnterpriseService
import com.diego.duarte.data_remote.service.AuthService
import org.koin.dsl.module


val dataRemoteModule = module {

    single { WebServiceFactory.provideOkHttpClient() }

    single<AuthService> { WebServiceFactory.createWebService(get()) }
    single<EnterpriseService> { WebServiceFactory.createWebService(get(), get()) }

    single<AuthRemoteDataSource> { AuthRemoteDataSourceImpl(get()) }
    single<EnterpriseRemoteDataSource>{EnterpriseRemoteDataSourceImpl(get())}

}