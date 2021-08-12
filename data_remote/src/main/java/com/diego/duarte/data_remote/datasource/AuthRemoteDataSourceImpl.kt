package com.diego.duarte.data_remote.datasource

import com.diego.duarte.data.LoginRemoteDataSource
import com.diego.duarte.data_remote.mapper.TokenResponseMapper
import com.diego.duarte.data_remote.model.TokenResponse
import com.diego.duarte.data_remote.service.LoginService
import kotlinx.coroutines.flow.flow
import org.koin.core.component.KoinComponent

class LoginRemoteDataSourceImpl(private val loginService: LoginService): LoginRemoteDataSource,
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
    }
}