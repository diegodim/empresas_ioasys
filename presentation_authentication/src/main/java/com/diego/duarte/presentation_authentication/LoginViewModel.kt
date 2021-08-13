package com.diego.duarte.presentation_authentication

import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.ViewModel
import com.diego.duarte.base_presentation.utils.extensions.*
import com.diego.duarte.domain.usecase.Login
import org.koin.core.component.KoinComponent

class LoginViewModel : ViewModel(), KoinComponent {

    private val login: Login by useCase()

    private val _loginState by viewState<Unit>()

    val loginViewState = _loginState.asLiveData()

    fun login(email: String, password: String){
        _loginState.postLoading()
        login(
            params = Login.Params(
                email,
                password
            ),
            onSuccess = { _loginState.postSuccess(it) },
            onError = { _loginState.postError(it) }
        )
    }
}