package com.diego.duarte.feature_main.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.setupActionBarWithNavController
import com.diego.duarte.base_feature.core.BaseFragment
import com.diego.duarte.base_feature.utils.delegateproperties.navDirections
import com.diego.duarte.base_feature.utils.delegateproperties.viewInflateBinding
import com.diego.duarte.base_feature.utils.extensions.loadUrl
import com.diego.duarte.base_presentation.model.EnterpriseBinding
import com.diego.duarte.feature_main.R
import com.diego.duarte.feature_main.databinding.FragmentEnterpriseBinding
import com.diego.duarte.feature_main.databinding.FragmentMainBinding
import com.diego.duarte.feature_main.navigation.EnterpriseNavigation


class EnterpriseFragment : BaseFragment() {

    private val binding by viewInflateBinding(FragmentEnterpriseBinding::inflate)
    private val navigation: EnterpriseNavigation by navDirections()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = binding.root

    override fun setupView() {
        super.setupView()
        binding.apply {
            enterpriseToolbar.also {
                (requireActivity() as? AppCompatActivity)?.apply {
                    setSupportActionBar(it)
                    setupActionBarWithNavController(requireView().findNavController())
                }
                it.title = navigation.enterprise.enterpriseName
            }
            enterpriseTextDescription.text = navigation.enterprise.description

            enterpriseImagePhoto.loadUrl(
                getString(R.string.url_image) + navigation.enterprise.photo.toString())

        }
    }

}