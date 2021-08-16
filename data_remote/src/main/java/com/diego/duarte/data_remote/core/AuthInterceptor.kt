package com.diego.duarte.data_remote.core

import com.diego.duarte.data_remote.model.TokenResponse
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

class Interceptor(private val token: TokenResponse) : Interceptor {

    // Create a interface with oauth2 token
    override fun intercept(chain: Interceptor.Chain): Response {
        var request: Request = chain.request()

        val builder: Request.Builder = request.newBuilder()


        builder.addHeader("access-token", token.accessToken.toString())
        builder.addHeader("uid", token.uid.toString())
        builder.addHeader("client", token.client.toString())

        request = builder.build()
        return chain.proceed(request)
    }
}