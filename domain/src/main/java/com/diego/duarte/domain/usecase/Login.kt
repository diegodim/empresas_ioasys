package com.diego.duarte.domain.usecase

import com.diego.duarte.domain.core.UseCase
import com.diego.duarte.domain.exeption.EmptyFieldException
import com.diego.duarte.domain.exeption.InvalidEmailException
import com.diego.duarte.domain.exeption.InvalidPasswordException
import com.diego.duarte.domain.exeption.MissingParamsException
import com.diego.duarte.domain.repository.AuthRepository
import com.diego.duarte.domain.utils.extensions.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow

class Login(private val repository: AuthRepository, scope: CoroutineScope) :
    UseCase<Unit, Login.Params>(scope) {

    data class Params(
        val email: String,
        val password: String
    )

    override fun run(params: Params?): Flow<Unit> = when{
        params == null -> throw MissingParamsException()
        params.password.isBlank() -> throw EmptyFieldException()
        params.email.isBlank() -> throw EmptyFieldException()
        params.email.isNotEmail() -> throw InvalidEmailException()
        params.password.isNotPassword() -> throw InvalidPasswordException()
        else -> repository.login(params.email, params.password)
    }

}