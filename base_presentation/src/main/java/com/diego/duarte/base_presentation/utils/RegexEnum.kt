package com.diego.duarte.base_presentation.utils

enum class RegexEnum(val value: Regex) {
    PASSWORD("""^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@${'$'}%^&*-]).{4,}$""".toRegex()),
    CNPJ("""(\\d{2})(\\d{3})(\\d{3})(\\d{4})(\\d{2})""".toRegex()),
    EMAIL("""[a-zA-Z0-9+._%\-+]{1,256}@[a-zA-Z0-9][a-zA-Z0-9\-]{0,64}(\.[a-zA-Z0-9][a-zA-Z0-9\-]{0,25})+""".toRegex()),
    CPF("""(\\d{3})(\\d{3})(\\d{2})""".toRegex()),
    DATE("""^(3[01]|[12][0-9]|0[1-9])/(1[0-2]|0[1-9])/[0-9]{4}$""".toRegex());

    fun match(string: String) = this.value.containsMatchIn(string)

}