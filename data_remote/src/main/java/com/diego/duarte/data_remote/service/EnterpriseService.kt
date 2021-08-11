package com.diego.duarte.data_remote.service

import retrofit2.Response

interface Enterprise {

    // Search enterprise api interface
    @GET("enterprises")
    fun getEnterprise(
        @Query("name") name: String
    ): Response<EnterprisesResponse>

    // Get a enterprise by id api interface
    @GET("enterprises/{enterprise}")
    fun getEnterprise(
        @Path("enterprise") enterpriseId: Int
    ): Observable<Response<Enterprise>>

}