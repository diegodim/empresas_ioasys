package com.diego.duarte.empresas

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class BaseApplication: Application() {

    override fun onCreate() {
        super.onCreate()



        startKoin {
            modules(

            ).androidContext(applicationContext)
        }
    }
}