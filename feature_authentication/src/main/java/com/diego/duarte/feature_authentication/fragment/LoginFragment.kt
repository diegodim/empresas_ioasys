package com.diego.duarte.feature_authentication.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.lifecycle.LifecycleOwner
import com.diego.duarte.base_feature.core.BaseFragment
import com.diego.duarte.base_feature.utils.delegateproperties.viewInflateBinding
import com.diego.duarte.base_feature.utils.extensions.addOnBackPressedCallback
import com.diego.duarte.feature_authentication.databinding.FragmentLoginBinding
import com.diego.duarte.presentation_authentication.LoginViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class LoginFragment : BaseFragment() {

    private val viewModel: LoginViewModel by viewModel()
    private val binding by viewInflateBinding(FragmentLoginBinding::inflate)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = binding.root


    override fun setupView() {
        super.setupView()
        binding.apply {
            loginButton.setOnClickListener {
                editTextEmail.error = ""
                editTextPassword.error = ""
                viewModel.login(
                    editTextEmail.editText?.text.toString(),
                    editTextPassword.editText?.text.toString()
                )

            }
            editTextEmail.editText?.addTextChangedListener {
                binding.editTextEmail.error = ""
                binding.editTextPassword.error = ""
            }
            editTextPassword.editText?.addTextChangedListener {
                editTextEmail.error = ""
                editTextPassword.error = ""
            }
        }
    }

    private fun handleWithLogin(owner: LifecycleOwner) {
        viewModel.loginViewState.onPostValue(
            lifecycleOwner = owner,
            onLoading = {
                binding.loginButton.isEnabled = false
                onStateLoading()
            },
            onSuccess = {
                binding.loginButton.isEnabled = true
                hideLoading()
            },
            onError = {
                binding.loginButton.isEnabled = true
                handleLoginError(it)
            }
        )
    }

    private fun handleLoginError(throwable: Throwable) {
        binding.editTextEmail.error = " "
        binding.editTextPassword.error = throwable.message.toString()
        onStateError(throwable)
    }

    override fun observeEvents(owner: LifecycleOwner) {
        addOnBackPressedCallback(owner) {
            requireActivity().finish()
        }
        handleWithLogin(owner)
    }

}