package com.diego.duarte.empresas

import android.app.Application
import org.koin.core.context.startKoin
import com.diego.duarte.di.*
import org.koin.android.ext.koin.androidContext

class BaseApplication: Application() {

    override fun onCreate() {
        super.onCreate()



        startKoin {
            modules(
                listOf(
                    presentationModule,
                    domainModule,
                    dataModule,
                    dataRemoteModule,
                    dataLocalModule
                )

            ).androidContext(applicationContext)
        }
    }
}