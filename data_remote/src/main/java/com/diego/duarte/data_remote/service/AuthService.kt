package com.diego.duarte.data_remote.service

import com.diego.duarte.data_remote.model.LoginResponse
import retrofit2.Response
import retrofit2.http.*

interface AuthService {

    // Login api interface
    @POST("users/auth/sign_in")
    @FormUrlEncoded
   suspend fun login(
        @Field("email") email: String,
        @Field("password") password: String
    ): Response<LoginResponse>


}