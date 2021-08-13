package com.diego.duarte.presentation_authentication

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.diego.duarte.base_presentation.core.ViewState
import com.diego.duarte.domain.exeption.InvalidPasswordException
import com.diego.duarte.domain.usecase.Login
import io.mockk.every
import io.mockk.invoke
import io.mockk.mockk
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import org.koin.dsl.module




class LoginViewModelTest{

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()


    private val login: Login = mockk()
    private lateinit var viewModel: LoginViewModel

    private val testModule = module {
        single { login }
    }

    @Before
    fun setup() {
        startKoin { modules(testModule) }
        viewModel = LoginViewModel()
    }

    @After
    fun reset() {
        stopKoin()
    }

    @Test
    fun `login WHEN has a success call from login use case MUST post success`() {
        // Given
        stubLoginSuccess()

        // When
        viewModel.login("", "")

        // Then
        assertEquals(ViewState.Status.SUCCESS, viewModel.loginViewState.value?.status)
    }

    @Test
    fun `login WHEN has a error from login use case MUST post that error`() {
        // Given
        val throwable = Throwable()
        stubLoginError(throwable)

        // When
        viewModel.login("", "")

        // Then
        assertEquals(ViewState.Status.ERROR, viewModel.loginViewState.value?.status)
        assertEquals(throwable, viewModel.loginViewState.value?.error)
    }
    @Test
    fun `login WHEN has a password exception from login use case MUST post a InvalidPasswordException`() {
        // Given
        val exception = InvalidPasswordException()
        stubLoginError(exception)

        // When
        viewModel.login("", "")

        // Then
        val error = viewModel.loginViewState.value?.error
        assertEquals(ViewState.Status.ERROR, viewModel.loginViewState.value?.status)
        assertEquals(exception, error)
        assertEquals(exception.message, error?.message)
    }

    private fun stubLoginSuccess() {
        every {
            login.invoke(params = any(), onError = any(), onSuccess = captureLambda())
        } answers {
            lambda<(Unit) -> Unit>().invoke(Unit)
        }
    }

    private fun stubLoginError(throwable: Throwable) {
        every {
            login.invoke(params = any(), onError = captureLambda(), onSuccess = any())
        } answers {
            lambda<(Throwable) -> Unit>().invoke(throwable)
        }
    }

}