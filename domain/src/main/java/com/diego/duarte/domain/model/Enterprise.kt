package com.diego.duarte.domain.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


data class Enterprise(

    val id: Int? = 0,
    val enterpriseName: String? = "",
    val photo: String? = "",
    val description: String? = "",
    val city: String? = "",
    val country: String? = "",
    val enterpriseType: EnterpriseType? = EnterpriseType(0, "")

)