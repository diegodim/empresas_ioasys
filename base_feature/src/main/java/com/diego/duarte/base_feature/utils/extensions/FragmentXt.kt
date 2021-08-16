package com.diego.duarte.base_feature.utils.extensions

import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleOwner

fun Fragment.addOnBackPressedCallback(owner: LifecycleOwner, onBackPressed: () -> Unit) {
    (requireActivity() as? AppCompatActivity)?.onBackPressedDispatcher?.addCallback(
        owner, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                onBackPressed()
            }
        }
    )
}