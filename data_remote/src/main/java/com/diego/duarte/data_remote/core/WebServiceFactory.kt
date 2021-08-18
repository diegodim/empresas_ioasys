package com.diego.duarte.data_remote.core

import com.diego.duarte.data.datasource.local.SessionLocalDataSource
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

const val BASE_URL = "https://empresas.ioasys.com.br/api/v1/"

object WebServiceFactory {

    fun buildRetrofit(okHttpClient: OkHttpClient): Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun provideOkHttpClient(): OkHttpClient {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

        return OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .connectTimeout(45, TimeUnit.SECONDS)
            .callTimeout(45, TimeUnit.SECONDS)
            .build()
    }

    inline fun <reified T> createWebService(okHttpClient: OkHttpClient): T =
        buildRetrofit(okHttpClient).create(T::class.java)

    inline fun <reified T> createWebService(okHttpClient: OkHttpClient,
                                            sessionLocal: SessionLocalDataSource
    ): T
    {
        val newClient: OkHttpClient = okHttpClient
            .newBuilder().
            addInterceptor(AuthInterceptor(sessionLocal.getToken()))
            .build()
        val newRetrofit: Retrofit = buildRetrofit(okHttpClient)
            .newBuilder()
            .client(newClient)
            .build()
        return newRetrofit.create(T::class.java)
    }

}