package com.diego.duarte.di

import com.diego.duarte.domain.core.ThreadContextProvider
import com.diego.duarte.domain.usecase.Login
import kotlinx.coroutines.CoroutineScope
import org.koin.dsl.module

val domainModule = module{
    single { ThreadContextProvider() }
    factory { (scope: CoroutineScope) ->
        Login(get(), scope)
    }
}