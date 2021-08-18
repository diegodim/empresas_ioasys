package com.diego.duarte.data.repository

import com.diego.duarte.data.datasource.local.SessionLocalDataSource
import com.diego.duarte.data.datasource.remote.AuthRemoteDataSource
import com.diego.duarte.data.factory.AuthFactory.DUMMY_EMAIL
import com.diego.duarte.data.factory.AuthFactory.DUMMY_PASSWORD
import com.diego.duarte.data.factory.AuthFactory.DUMMY_TOKEN
import com.diego.duarte.data.factory.testFlow
import junit.framework.Assert.assertEquals
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.doNothing
import org.mockito.MockitoAnnotations
import org.mockito.kotlin.any
import org.mockito.kotlin.then
import org.mockito.kotlin.times
import org.mockito.kotlin.whenever

class AuthRepositoryImplTest{

    @Mock
    private lateinit var authRemoteDataSource: AuthRemoteDataSource

    @Mock
    private lateinit var sessionLocalDataSource: SessionLocalDataSource

    private lateinit var repositoryImpl: AuthRepositoryImpl

    @Before
    fun setup(){
        MockitoAnnotations.openMocks(this)
        repositoryImpl = AuthRepositoryImpl(sessionLocalDataSource, authRemoteDataSource)
    }

    @Test
    fun `validate credential WHEN called MUST return Unit`(){

        whenever(authRemoteDataSource.login(any(),any())).thenReturn(flowOf(DUMMY_TOKEN))

        repositoryImpl.login(
            DUMMY_EMAIL, DUMMY_PASSWORD
        ).testFlow {
            assertEquals(Unit, this)
            then(sessionLocalDataSource).should(times(1)).saveToken(DUMMY_TOKEN)
        }

    }


    @Test(expected = Throwable::class)
    fun `validate credential WHEN has a error MUST return a Throwable`(){

        whenever(authRemoteDataSource.login(any(),any())).thenThrow(Throwable())

        runBlocking {
            repositoryImpl.login(
                DUMMY_EMAIL, DUMMY_PASSWORD
            ).collect {  }
        }
    }

    @Test
    fun `isLogged WHEN called MUST return True`() {

        whenever(sessionLocalDataSource.getToken()).thenReturn(DUMMY_TOKEN)

        repositoryImpl.isLogged().testFlow {
            assertEquals(true, this)
        }
    }

    @Test
    fun `isLogged WHEN called MUST return False`() {

        whenever(sessionLocalDataSource.getToken()).thenReturn(null)

        repositoryImpl.isLogged().testFlow {
            assertEquals(false, this)
        }
    }

    @Test(expected = Throwable::class)
    fun `isLogged WHEN has a error MUST return a Throwable`(){

        whenever(sessionLocalDataSource.getToken()).thenThrow(Throwable())

        runBlocking {
            repositoryImpl.isLogged().collect {  }
        }
    }

    @Test
    fun `logout WHEN called MUST return Unit`(){

        doNothing().`when`(sessionLocalDataSource).deleteToken()

        repositoryImpl.logout().testFlow {
            assertEquals(Unit, this)
        }

    }

    @Test(expected = Throwable::class)
    fun `logout WHEN called MUST return Throwable`(){

        whenever(sessionLocalDataSource.deleteToken()).thenThrow(Throwable())

        runBlocking {
            repositoryImpl.logout().collect {  }
        }

    }

}