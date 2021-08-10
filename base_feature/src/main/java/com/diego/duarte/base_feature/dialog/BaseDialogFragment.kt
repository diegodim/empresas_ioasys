package com.diego.duarte.base_feature.dialog

import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentManager

open class BaseDialogFragment : DialogFragment() {

    private var isLoading = false

    fun show(manager: FragmentManager) {
        show(manager, "")
    }

    override fun show(manager: FragmentManager, tag: String?) {
        if (!isAdded) {
            isLoading = true
            super.show(manager, tag)
        }
    }

    override fun dismissAllowingStateLoss() {
        if (isLoading) {
            isLoading = false
            super.dismissAllowingStateLoss()
        }
    }
}