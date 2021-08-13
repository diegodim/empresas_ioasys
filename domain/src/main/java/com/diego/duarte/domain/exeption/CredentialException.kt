package com.diego.duarte.domain.exeption

sealed class CredentialException(message: String, title: String? = null) :
    DomainException(message, title)

class InvalidCredentialException :
    CredentialException("Credenciais informadas são inválidas, tente novamente.")

class InvalidEmailException :
    CredentialException("O e-mail informado é inválido.")

class InvalidPasswordException : CredentialException("Senha inválida.")
