package com.diego.duarte.data_remote.mapper

import com.diego.duarte.data_remote.core.DataRemoteMapper
import com.diego.duarte.data_remote.model.EnterpriseTypeResponse
import com.diego.duarte.domain.model.EnterpriseType

class EnterpriseTypeResponseMapper: DataRemoteMapper<EnterpriseTypeResponse, EnterpriseType>{

    override fun toDomain(remote: EnterpriseTypeResponse)= EnterpriseType(
        id = remote.id,
        enterpriseTypeName = remote.enterpriseTypeName
    )

}