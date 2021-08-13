package com.diego.duarte.data_remote.datasource

import com.diego.duarte.data.AuthRemoteDataSource
import com.diego.duarte.data_remote.mapper.TokenResponseMapper
import com.diego.duarte.data_remote.model.TokenResponse
import com.diego.duarte.data_remote.service.LoginService
import com.diego.duarte.domain.exeption.CredentialException
import com.diego.duarte.domain.exeption.InvalidCredentialException
import com.diego.duarte.domain.exeption.MissingParamsException
import kotlinx.coroutines.flow.flow
import org.koin.core.component.KoinComponent

class AuthRemoteDataSourceImpl(private val loginService: LoginService): AuthRemoteDataSource,
    KoinComponent {
    
    override fun login(email: String, password:String) = flow {
        val response = loginService.login(email, password)
        if(response.isSuccessful){
            val token = TokenResponse()
            response.headers().let{
                token.accessToken = it.get("access-token")
                token.uid = it.get("uid")
                token.client = it.get("client")
            }
            emit(
                TokenResponseMapper().toDomain(token)
            )
        }
        else
            emit(throw InvalidCredentialException())

    }
}