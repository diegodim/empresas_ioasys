package com.diego.duarte.data.repository

import com.diego.duarte.data.datasource.remote.AuthRemoteDataSource
import com.diego.duarte.data.datasource.local.SessionLocalDataSource
import com.diego.duarte.domain.model.isNullOrBlank
import com.diego.duarte.domain.repository.AuthRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map

class AuthRepositoryImpl(private val sessionLocalDataSource: SessionLocalDataSource,
                         private val authRemoteDataSource: AuthRemoteDataSource
): AuthRepository {

    override fun login(email: String, password: String)
    = authRemoteDataSource.login(email, password).map {
        sessionLocalDataSource.saveToken(it)
    }

    override fun isLogged() = flow{
        emit(
            sessionLocalDataSource.getToken().isNullOrBlank()
        )
    }

    override fun logout(): Flow<Unit> {
        sessionLocalDataSource.deleteToken()
        return flow{emit(Unit)}
    }

}