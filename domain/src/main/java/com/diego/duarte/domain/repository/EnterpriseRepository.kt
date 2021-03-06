package com.diego.duarte.domain.repository

import com.diego.duarte.domain.model.Enterprise
import kotlinx.coroutines.flow.Flow

interface EnterpriseRepository {

    fun search(key: String): Flow<List<Enterprise>>
}