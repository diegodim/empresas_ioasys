package com.diego.duarte.data_remote.mapper

import com.diego.duarte.data_remote.core.DataRemoteMapper
import com.diego.duarte.data_remote.model.TokenResponse
import com.diego.duarte.domain.model.Token

class TokenResponseMapper: DataRemoteMapper<TokenResponse, Token> {
    override fun toDomain(remote: TokenResponse) = Token (
        accessToken = remote.accessToken,
        uid = remote.uid,
        client = remote.client
    )
}