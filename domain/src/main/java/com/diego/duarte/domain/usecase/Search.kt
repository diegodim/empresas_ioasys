package com.diego.duarte.domain.usecase

import com.diego.duarte.domain.core.UseCase
import com.diego.duarte.domain.exeption.MissingParamsException
import com.diego.duarte.domain.model.Enterprise
import com.diego.duarte.domain.repository.EnterpriseRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow

class Search(private val repository: EnterpriseRepository, scope: CoroutineScope): UseCase<List<Enterprise>, Search.Params>(scope) {

    data class Params(
        val key: String
    )

    override fun run(params: Params?): Flow<List<Enterprise>>  = when{
        params == null -> throw MissingParamsException()
        else -> repository.search(params.key)
    }

}