package com.diego.duarte.data.repository

import com.diego.duarte.data.LoginRemoteDataSource
import com.diego.duarte.data.SessionLocalDataSource
import com.diego.duarte.domain.model.Token
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map

class LoginRepository( private val sessionLocalDataSource: SessionLocalDataSource,
                        private val loginRemoteDataSource: LoginRemoteDataSource) {

    fun login(email: String, password: String)
    = loginRemoteDataSource.login(email, password).map {
        sessionLocalDataSource.saveToken(it)
    }

    fun logout(): Flow<Unit> {
        sessionLocalDataSource.deleteToken()
        return flow{emit(Unit)}
    }

}