package com.diego.duarte.data.repository

import com.diego.duarte.data.LoginRemoteDataSource
import com.diego.duarte.data.SessionLocalDataSource
import com.diego.duarte.domain.repository.LoginRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map

class LoginRepositoryImpl( private val sessionLocalDataSource: SessionLocalDataSource,
                        private val loginRemoteDataSource: LoginRemoteDataSource): LoginRepository {

    override fun login(email: String, password: String)
    = loginRemoteDataSource.login(email, password).map {
        sessionLocalDataSource.saveToken(it)
    }

    override fun logout(): Flow<Unit> {
        sessionLocalDataSource.deleteToken()
        return flow{emit(Unit)}
    }

}