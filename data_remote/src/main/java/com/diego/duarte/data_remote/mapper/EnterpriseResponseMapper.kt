package com.diego.duarte.data_remote.mapper

import com.diego.duarte.data_remote.core.DataRemoteMapper
import com.diego.duarte.data_remote.model.EnterpriseResponse
import com.diego.duarte.domain.model.Enterprise

class EnterpriseResponseMapper: DataRemoteMapper<EnterpriseResponse, Enterprise> {
    override fun toDomain(remote: EnterpriseResponse) = Enterprise(
        id = remote.id,
        enterpriseName = remote.enterpriseName,
        photo = remote.photo,
        description = remote.description,
        city = remote.city,
        country = remote.country,
        enterpriseType = EnterpriseTypeResponseMapper().toDomain(remote.enterpriseType)
    )
}