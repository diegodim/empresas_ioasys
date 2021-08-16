package com.diego.duarte.di

import com.diego.duarte.presentation_authentication.LoginViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {

    viewModel { LoginViewModel() }
}