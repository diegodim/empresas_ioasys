package com.diego.duarte.di

import com.diego.duarte.presentation_authentication.LoginViewModel
import com.diego.duarte.presentation_main.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {

    viewModel { LoginViewModel() }
    viewModel { MainViewModel() }
}