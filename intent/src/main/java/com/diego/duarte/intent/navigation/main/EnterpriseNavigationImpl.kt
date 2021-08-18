package com.diego.duarte.intent.navigation.main

import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.diego.duarte.base_presentation.model.EnterpriseBinding
import com.diego.duarte.feature_main.navigation.EnterpriseNavigation
import com.diego.duarte.feature_main.fragment.EnterpriseFragmentArgs

class EnterpriseNavigationImpl(private val fragment: Fragment): EnterpriseNavigation {

    private val arguments = fragment.navArgs<EnterpriseFragmentArgs>().value

    override val enterprise: EnterpriseBinding
        get() = arguments.enterprise
}