package com.diego.duarte.data

import com.diego.duarte.data_local.model.TokenLocal

interface SessionLocalDataSourceI {

    companion object {

        const val ACCESS_TOKEN: String = "com.diego.duarte.data.accessToken"
        const val UID: String = "com.diego.duarte.data.uid"
        const val CLIENT: String = "com.diego.duarte.data.client"

    }

    fun saveToken(token: TokenLocal)
    fun getToken(): TokenLocal
    fun deleteToken()
}