package com.diego.duarte.data_remote.model

import com.google.gson.annotations.SerializedName

data class EnterprisesResponse(
    @SerializedName("enterprises")
    val enterprises: List<EnterpriseResponse>
)