package com.diego.duarte.base_feature.core

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleOwner
import com.diego.duarte.base_feature.dialog.LoadingDialog
import com.diego.duarte.base_presentation.core.ViewStateListener

import org.koin.core.component.KoinComponent

abstract class BaseFragment : Fragment(), ViewStateListener, KoinComponent {

    private val loadingDialog = LoadingDialog()

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        observeEvents(viewLifecycleOwner)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupView()
    }

    override fun onStateError(error: Throwable) {
        hideLoading()
        Toast.makeText(requireContext(), error.message, Toast.LENGTH_LONG).show()
    }

    override fun onStateLoading(){
        childFragmentManager.let { loadingDialog.show(this) }
    }
    override fun hideLoading() {
        loadingDialog.dismiss()
    }


    protected open fun observeEvents(owner: LifecycleOwner) = Unit

    protected open fun setupView() = Unit

}