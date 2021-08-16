package com.diego.duarte.data_local.mapper


import com.diego.duarte.data_local.core.DataLocalMapper
import com.diego.duarte.data_local.model.TokenLocal
import com.diego.duarte.domain.model.Token

class TokenLocalMapper: DataLocalMapper<TokenLocal?, Token?> {

    override fun toLocal(domain: Token?) = TokenLocal (
        accessToken = domain?.accessToken,
        uid = domain?.uid,
        client = domain?.client

    )

    override fun fromLocal(local: TokenLocal?) = Token (
        accessToken = local?.accessToken,
        uid = local?.uid,
        client = local?.client
    )
}