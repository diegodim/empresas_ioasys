package com.diego.duarte.data_remote

import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface LoginService {

    // Login api interface
    @POST("users/auth/sign_in")
    @FormUrlEncoded
    fun login(
        @Field("email") email: String,
        @Field("password") password: String?
    ): Response<LoginResponse>
}