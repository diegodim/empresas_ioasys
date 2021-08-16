package com.diego.duarte.data

import com.diego.duarte.domain.model.Enterprise
import kotlinx.coroutines.flow.Flow

interface EnterpriseRemoteDataSource {
    
    fun searchByString(key: String): Flow<List<Enterprise>>
}