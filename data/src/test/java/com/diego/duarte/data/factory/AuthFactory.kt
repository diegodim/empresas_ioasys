package com.diego.duarte.data.factory

import com.diego.duarte.domain.model.Token

object AuthFactory {
    const val DUMMY_PASSWORD = "123456"
    const val DUMMY_EMAIL = "test@test.com"
    val DUMMY_TOKEN = Token("12345", "123","1234")
}