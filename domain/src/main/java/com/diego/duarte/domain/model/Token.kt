package com.diego.duarte.domain.model




data class Token(

    var accessToken: String? = "",
    var uid: String? = "",
    var client: String ?= ""

)
{

}

fun Token?.isNullOrBlank():Boolean{
    this?.let {
        if(!it.accessToken.isNullOrBlank())
            return true
    }
    return false
}