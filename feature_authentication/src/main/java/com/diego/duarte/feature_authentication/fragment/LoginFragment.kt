package com.diego.duarte.feature_authentication.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.lifecycle.LifecycleOwner
import com.diego.duarte.base_feature.core.BaseFragment
import com.diego.duarte.base_feature.utils.delegateproperties.navDirections
import com.diego.duarte.base_feature.utils.delegateproperties.viewInflateBinding
import com.diego.duarte.base_feature.utils.extensions.addOnBackPressedCallback
import com.diego.duarte.feature_authentication.databinding.FragmentLoginBinding
import com.diego.duarte.feature_authentication.navigation.LoginNavigation
import com.diego.duarte.presentation_authentication.LoginViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class LoginFragment : BaseFragment() {

    private val viewModel: LoginViewModel by viewModel()

    private val binding by viewInflateBinding(FragmentLoginBinding::inflate)

    private val navigation: LoginNavigation by navDirections()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = binding.root


    override fun setupView() {
        super.setupView()
        binding.apply {
            loginButtonEnter.setOnClickListener {
                loginInputTextEmail.error = ""
                loginInputTextPassword.error = ""
                viewModel.login(
                    loginInputTextEmail.editText?.text.toString(),
                    loginInputTextPassword.editText?.text.toString()
                )

            }
            loginInputTextEmail.editText?.addTextChangedListener {
                loginInputTextEmail.error = ""
                loginInputTextPassword.error = ""
            }
            loginInputTextPassword.editText?.addTextChangedListener {
                loginInputTextEmail.error = ""
                loginInputTextPassword.error = ""
            }
        }
    }

    private fun handleWithLogin(owner: LifecycleOwner) {
        viewModel.loginViewState.onPostValue(
            lifecycleOwner = owner,
            onLoading = {
                binding.loginButtonEnter.isEnabled = false
                onStateLoading()
            },
            onSuccess = {
                binding.loginButtonEnter.isEnabled = true
                hideLoading()
                navigation.navigateToMain()
            },
            onError = {
                binding.loginButtonEnter.isEnabled = true
                handleLoginError(it)
            }
        )
    }



    private fun handleLoginError(throwable: Throwable) {
        binding.loginInputTextEmail.error = " "
        binding.loginInputTextPassword.error = throwable.message.toString()
        onStateError(throwable)
    }

    override fun observeEvents(owner: LifecycleOwner) {
        addOnBackPressedCallback(owner) {
            requireActivity().finish()
        }
        handleWithLogin(owner)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        viewModel.clearState()

    }

}