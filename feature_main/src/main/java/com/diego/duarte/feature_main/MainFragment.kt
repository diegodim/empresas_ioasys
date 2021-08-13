package com.diego.duarte.feature_main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import com.diego.duarte.base_feature.core.BaseFragment
import com.diego.duarte.base_feature.utils.delegateproperties.viewInflateBinding
import com.diego.duarte.feature_main.databinding.FragmentMainBinding


class MainFragment : BaseFragment() {

    private val binding by viewInflateBinding(FragmentMainBinding::inflate)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = binding.root


}