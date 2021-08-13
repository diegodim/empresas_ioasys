package com.diego.duarte.di.intent

import androidx.fragment.app.Fragment
import com.diego.duarte.feature_authentication.navigation.LoginNavigation
import com.diego.duarte.intent.navigation.login.LoginNavigationImpl
import org.koin.dsl.module

val intentAuthenticationModule = module{
    factory<LoginNavigation>{ (fragment: Fragment) ->
        LoginNavigationImpl(fragment)
    }
}