package com.diego.duarte.domain.exeption

/*
 * Created by Filipi Andrade Rocha on 19/01/2021.
 */

open class DomainException(message: String, title: String? = null) :
    RuntimeException(message, RuntimeException(title))

class EmptyFieldException : ParamException("Campo obrigatório.")