package com.diego.duarte.repository

import kotlinx.coroutines.flow.Flow

interface LoginRepository {
    fun logout(): Flow<Unit>
    fun login(email: String, password: String): Flow<Unit>
}