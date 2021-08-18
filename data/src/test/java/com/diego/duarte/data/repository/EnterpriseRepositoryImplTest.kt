package com.diego.duarte.data.repository


import com.diego.duarte.data.datasource.remote.EnterpriseRemoteDataSource
import com.diego.duarte.data.factory.EnterpriseFactory.DUMMY_ENTERPRISES
import com.diego.duarte.data.factory.EnterpriseFactory.DUMMY_QUERY
import com.diego.duarte.data.factory.testFlow
import com.diego.duarte.domain.model.Enterprise
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.runBlocking
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import org.mockito.kotlin.any
import org.mockito.kotlin.whenever

class EnterpriseRepositoryImplTest{

    @Mock
    private lateinit var enterpriseRemoteDataSource: EnterpriseRemoteDataSource

    private lateinit var repositoryImpl: EnterpriseRepositoryImpl

    @Before
    fun setup(){
        MockitoAnnotations.openMocks(this)
        repositoryImpl = EnterpriseRepositoryImpl(enterpriseRemoteDataSource)
    }

    @Test
    fun `search WHEN called MUST return a list of Enterprises`(){

        whenever(enterpriseRemoteDataSource.searchByString(any())).thenReturn(flowOf(DUMMY_ENTERPRISES))

        repositoryImpl.search(DUMMY_QUERY).testFlow {
            assertEquals(DUMMY_ENTERPRISES, this)
        }
    }

    @Test
    fun `search WHEN called MUST return empty list Enterprises`(){

        whenever(enterpriseRemoteDataSource.searchByString(any())).thenReturn(flowOf(listOf()))

        repositoryImpl.search(DUMMY_QUERY).testFlow {
            assertEquals(listOf<Enterprise>(), this)
        }
    }

    @Test(expected = Throwable::class)
    fun `search WHEN called MUST return a Throwable`(){

        whenever(enterpriseRemoteDataSource.searchByString(any())).thenThrow(Throwable())

        runBlocking {
            repositoryImpl.search(DUMMY_QUERY).collect {  }
        }
    }
}