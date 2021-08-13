package com.diego.duarte.base_presentation.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class EnterpriseBinding(

    val id: Int? = 0,
    val enterpriseName: String? = "",
    val photo: String? = "",
    val description: String? = "",
    val city: String? = "",
    val country: String? = "",
    val enterpriseType: EnterpriseTypeBinding? = EnterpriseTypeBinding(0, "")

) : Parcelable
