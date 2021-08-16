package com.diego.duarte.data

import com.diego.duarte.domain.model.Token
import kotlinx.coroutines.flow.Flow

interface AuthRemoteDataSource {
    fun login(
        email: String,
        password: String
    ): Flow<Token>
}