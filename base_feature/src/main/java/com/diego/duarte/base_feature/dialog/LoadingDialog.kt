package com.diego.duarte.base_feature.dialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.diego.duarte.base_feature.R
import com.diego.duarte.base_feature.databinding.DialogLoadingBinding

class LoadingDialog: BaseFullScreenDialog() {

    private lateinit var binding: DialogLoadingBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = DialogLoadingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        dialog?.window?.run {
            dialog?.setCancelable(false)
            setBackgroundDrawableResource(R.color.white_60)
        }
    }

}