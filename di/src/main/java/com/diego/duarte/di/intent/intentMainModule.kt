package com.diego.duarte.di.intent

import androidx.fragment.app.Fragment
import com.diego.duarte.feature_main.navigation.MainNavigation
import com.diego.duarte.intent.navigation.main.MainNavigationImpl
import org.koin.dsl.module

val intentMainModule  = module{
    factory<MainNavigation>{ (fragment: Fragment) ->
        MainNavigationImpl(fragment)
    }
}