package com.diego.duarte.base_presentation.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class EnterpriseTypeBinding(
    val id: Int = 0,
    val enterpriseTypeName: String? = ""
) : Parcelable
