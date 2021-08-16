package com.diego.duarte.data_remote.datasource

import com.diego.duarte.data_remote.mapper.TokenResponseMapper
import com.diego.duarte.data_remote.model.TokenResponse
import com.diego.duarte.data_remote.service.EnterpriseService
import com.diego.duarte.domain.exeption.InvalidCredentialException
import kotlinx.coroutines.flow.flow
import org.koin.core.component.KoinComponent

class EnterpriseRemoteDataSourceImpl(private val enterpriseService: EnterpriseService):
    KoinComponent {

        /*fun search(key: String) = flow{
            val response = enterpriseService.getEnterprise(key)

            if(response.isSuccessful){
                emit(
                    TokenResponseMapper().toDomain(token)
                )
            }
            else
                emit(throw InvalidCredentialException())
        }*/
}