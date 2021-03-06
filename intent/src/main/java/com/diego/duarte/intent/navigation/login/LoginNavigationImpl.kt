package com.diego.duarte.intent.navigation.login


import androidx.fragment.app.Fragment
import com.diego.duarte.feature_authentication.navigation.LoginNavigation
import com.diego.duarte.intent.navigate
import com.diego.duarte.feature_authentication.fragment.LoginFragmentDirections


class LoginNavigationImpl(private val fragment: Fragment) : LoginNavigation {

    override fun navigateToMain() = fragment.navigate(
        LoginFragmentDirections.actionLoginFragmentToMainNavigation()
    )

}

