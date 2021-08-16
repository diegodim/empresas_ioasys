package com.diego.duarte.data.datasource.remote

import com.diego.duarte.domain.model.Token
import kotlinx.coroutines.flow.Flow

interface AuthRemoteDataSource {
    fun login(
        email: String,
        password: String
    ): Flow<Token>
}