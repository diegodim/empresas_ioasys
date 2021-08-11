package com.diego.duarte.data_local

import com.diego.duarte.data.SessionLocalDataSource
import com.diego.duarte.data.SessionLocalDataSource.Companion.ACCESS_TOKEN
import com.diego.duarte.data.SessionLocalDataSource.Companion.CLIENT
import com.diego.duarte.data.SessionLocalDataSource.Companion.UID
import com.diego.duarte.data_local.mapper.TokenLocalMapper
import com.diego.duarte.data_local.model.TokenLocal
import com.diego.duarte.domain.model.Token


class SessionLocalDataSourceImpl(
    private val preferencesHelper: PreferencesHelper
): SessionLocalDataSource {

    private var token: Token? = null

    override fun saveToken(token: Token){
        this.token = token
        preferencesHelper.saveString(ACCESS_TOKEN, token.accessToken)
        preferencesHelper.saveString(UID, token.uid)
        preferencesHelper.saveString(CLIENT, token.client)
    }

    override fun getToken(): Token? = when(token == null){
        true -> {
            TokenLocalMapper().fromLocal(TokenLocal(
                preferencesHelper.getString(ACCESS_TOKEN),
                preferencesHelper.getString(UID),
                preferencesHelper.getString(CLIENT)))
        }
        false -> token
    }

    override fun deleteToken(){

        token = null
        preferencesHelper.deleteKey(ACCESS_TOKEN)
        preferencesHelper.deleteKey(UID)
        preferencesHelper.deleteKey(CLIENT)
    }
}