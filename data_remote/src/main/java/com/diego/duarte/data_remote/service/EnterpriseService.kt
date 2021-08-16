package com.diego.duarte.data_remote.service

import com.diego.duarte.data_remote.model.EnterprisesResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface EnterpriseService {

    // Search enterprise api interface
    @GET("enterprises")
    suspend fun getEnterprise(
        @Query("name") name: String
    ): Response<EnterprisesResponse>

}