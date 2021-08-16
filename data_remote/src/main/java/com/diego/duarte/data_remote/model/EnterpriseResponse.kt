package com.diego.duarte.data_remote.model

import com.google.gson.annotations.SerializedName

data class EnterpriseResponse(
    @SerializedName("id")
    val id: Int = 0,
    @SerializedName("enterprise_name")
    val enterpriseName: String = "",
    @SerializedName("photo")
    val photo: String = "",
    @SerializedName("description")
    val description: String = "",
    @SerializedName("city")
    val city: String = "",
    @SerializedName("country")
    val country: String = "",
    @SerializedName("enterpriseType")
    val enterpriseType: EnterpriseTypeResponse = EnterpriseTypeResponse(0, "")
)