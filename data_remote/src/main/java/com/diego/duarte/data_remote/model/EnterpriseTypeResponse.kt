package com.diego.duarte.data_remote.model

import com.google.gson.annotations.SerializedName

data class EnterpriseTypeResponse(
    @SerializedName("id")
    val id: Int,
    @SerializedName("enterprise_type_name")
    val enterpriseTypeName: String
)