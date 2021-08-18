package com.diego.duarte.data.datasource.local

import com.diego.duarte.domain.model.Token


interface SessionLocalDataSource {

    companion object {

        const val ACCESS_TOKEN: String = "com.diego.duarte.data.accessToken"
        const val UID: String = "com.diego.duarte.data.uid"
        const val CLIENT: String = "com.diego.duarte.data.client"

    }

    fun saveToken(token: Token)
    fun getToken(): Token?
    fun deleteToken()
}