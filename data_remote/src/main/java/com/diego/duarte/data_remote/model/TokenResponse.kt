package com.diego.duarte.data_remote.model

data class TokenResponse (
    var accessToken: String? = "",
    var uid: String? = "",
    var client: String ?= ""
)