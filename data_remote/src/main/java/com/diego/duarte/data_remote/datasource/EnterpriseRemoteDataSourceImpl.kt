package com.diego.duarte.data_remote.datasource

import com.diego.duarte.data.datasource.remote.EnterpriseRemoteDataSource
import com.diego.duarte.data_remote.mapper.EnterpriseResponseMapper
import com.diego.duarte.data_remote.service.EnterpriseService
import com.diego.duarte.domain.exeption.InvalidCredentialException
import kotlinx.coroutines.flow.flow
import org.koin.core.component.KoinComponent

class EnterpriseRemoteDataSourceImpl(private val enterpriseService: EnterpriseService):
    EnterpriseRemoteDataSource, KoinComponent {

        override fun searchByString(key: String) = flow{
            val response = enterpriseService.getEnterprise(key)

            if(response.isSuccessful) {
                response.body()?.let {
                    emit(EnterpriseResponseMapper().toDomain(it.enterprises))
                }
            }
            else
                emit(throw InvalidCredentialException())
        }
}