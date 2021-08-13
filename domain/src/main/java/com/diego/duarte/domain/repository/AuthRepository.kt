package com.diego.duarte.domain.repository

import kotlinx.coroutines.flow.Flow

interface AuthRepository {
    fun logout(): Flow<Unit>
    fun login(email: String, password: String): Flow<Unit>
    fun isLogged(): Flow<Boolean>
}