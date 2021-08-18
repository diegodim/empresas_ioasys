package com.diego.duarte.di

import com.diego.duarte.domain.core.ThreadContextProvider
import com.diego.duarte.domain.usecase.Login
import com.diego.duarte.domain.usecase.Search
import kotlinx.coroutines.CoroutineScope
import org.koin.dsl.module

val domainModule = module{
    single { ThreadContextProvider() }
    factory { (scope: CoroutineScope) ->
        Login(get(), scope)
    }

    factory { (scope: CoroutineScope) ->
        Search(get(), scope)
    }
}