package com.diego.duarte.data.repository

import com.diego.duarte.data.datasource.remote.EnterpriseRemoteDataSource
import com.diego.duarte.domain.repository.EnterpriseRepository

class EnterpriseRepositoryImpl(private val enterpriseRemoteDataSource: EnterpriseRemoteDataSource):
    EnterpriseRepository {

    override fun search(key: String) = enterpriseRemoteDataSource.searchByString(key)
}