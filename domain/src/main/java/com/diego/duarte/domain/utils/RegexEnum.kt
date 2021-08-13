package com.diego.duarte.base_presentation.utils

enum class RegexEnum(val value: Regex) {
    PASSWORD("""(\d{6})""".toRegex()),
    EMAIL("""^[a-z0-9_%+-]+([.-][a-z0-9]+)*@[a-z0-9]+([.-][a-z0-9]+)*\.[a-z]{2,3}$""".toRegex()),
    DATE("""^(3[01]|[12][0-9]|0[1-9])/(1[0-2]|0[1-9])/[0-9]{4}$""".toRegex());

    fun match(string: String) = this.value.containsMatchIn(string)

}