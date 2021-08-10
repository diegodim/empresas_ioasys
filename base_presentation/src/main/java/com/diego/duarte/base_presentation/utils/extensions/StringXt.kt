package com.diego.duarte.base_presentation.utils.extensions

import com.diego.duarte.base_presentation.utils.RegexEnum
import java.text.SimpleDateFormat
import java.util.*

val localePtBr = Locale("pt", "BR")

fun String.isPassword() = RegexEnum.PASSWORD.match(this)
fun String.isNotPassword() = !isPassword()

fun String.isCpf(): Boolean {
    if (this.length != 11) return false

    var numerosIguais = true
    this.forEach {
        if (this.first() != it) {
            numerosIguais = false
        }
    }
    if (numerosIguais) return false

    val dig10: Char
    val dig11: Char
    var sm: Int
    var i: Int
    var r: Int
    var num: Int
    var peso: Int

    try {
        sm = 0
        peso = 10
        i = 0
        while (i < 9) {
            num = this[i].toInt() - 48
            sm += num * peso
            peso -= 1
            i++
        }

        r = 11 - sm % 11
        dig10 = if (r == 10 || r == 11) '0' else (r + 48).toChar() // converte no respectivo caractere numerico

        sm = 0
        peso = 11
        i = 0
        while (i < 10) {
            num = this[i].toInt() - 48
            sm += num * peso
            peso -= 1
            i++
        }
        r = 11 - sm % 11
        dig11 = if (r == 10 || r == 11) '0' else (r + 48).toChar()

        return dig10 == this[9] && dig11 == this[10]
    } catch (error: InputMismatchException) {
        return false
    }
}

fun String.isNotCpf() = !isCpf()

fun String.isDate(format: String = "dd/MM/yyyy") = try {
    SimpleDateFormat(format, Locale.getDefault()).also {
        it.isLenient = false
        it.parse(this)
    }
    RegexEnum.DATE.value.matches(this)
} catch (e: Exception) {
    false
}

fun String.isNotDate(format: String = "dd/MM/yyyy") = !isDate(format)

fun String.removeNotNumbers() = this.replace("[^\\d]".toRegex(), "")

fun String.isPhoneNumber() = length == 11
fun String.isNotPhoneNumber() = !isPhoneNumber()

fun String.isEmail() = RegexEnum.EMAIL.match(this)
fun String.isNotEmail() = !isEmail()

fun String.isCep() = length == 8
fun String.isNotCep() = !isCep()
