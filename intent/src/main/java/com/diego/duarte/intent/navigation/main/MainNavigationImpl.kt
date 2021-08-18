package com.diego.duarte.intent.navigation.main

import androidx.fragment.app.Fragment
import com.diego.duarte.base_presentation.model.EnterpriseBinding
import com.diego.duarte.feature_main.navigation.MainNavigation
import com.diego.duarte.intent.navigate
import com.diego.duarte.feature_main.fragment.MainFragmentDirections

class MainNavigationImpl(private val fragment: Fragment): MainNavigation {
    override fun navigateToEnterprise(enterprise: EnterpriseBinding) = fragment.navigate(
        MainFragmentDirections.actionMainFragmentToEnterpriseFragment(enterprise)
    )
}