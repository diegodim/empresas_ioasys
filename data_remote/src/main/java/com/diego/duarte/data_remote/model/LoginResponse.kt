package com.diego.duarte.data_remote.model

data class LoginResponse(
    var success: Boolean = false,
    var error: List<String> = listOf()
)
