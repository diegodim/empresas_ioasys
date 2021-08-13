package com.diego.duarte.data_local.core

import android.content.Context

class PreferencesHelper(context: Context) {

    private val sharedPreferences = context.getSharedPreferences("SHARED_PREFERENCES_APP_NAME", Context.MODE_PRIVATE)

    fun saveString(key: String, data: String?) = sharedPreferences.edit().run {
        putString(key, data?.let { it })
        apply()
    }

    fun getString(key: String) = sharedPreferences.run {
        getString(key, null)?.let {
            it
        }
    }

    fun deleteKey(key: String) = sharedPreferences.edit().run {
        remove(key)
        apply()
    }

    companion object {
        private const val SHARED_PREFERENCES_APP_NAME = "com.diego.duarte.data_local.datasource.PreferencesHelper"
    }

}