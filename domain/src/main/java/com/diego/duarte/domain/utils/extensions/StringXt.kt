package com.diego.duarte.domain.utils.extensions

import com.diego.duarte.domain.utils.RegexEnum

fun String.isEmail() = RegexEnum.EMAIL.match(this)
fun String.isNotEmail() = !isEmail()
fun String.isPassword() = RegexEnum.PASSWORD.match(this)
fun String.isNotPassword() = !isPassword()