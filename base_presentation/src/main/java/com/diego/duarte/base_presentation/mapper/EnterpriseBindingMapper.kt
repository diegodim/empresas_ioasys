package com.diego.duarte.base_presentation.mapper

import com.diego.duarte.base_presentation.core.PresentationMapper
import com.diego.duarte.base_presentation.model.EnterpriseBinding
import com.diego.duarte.domain.model.Enterprise

class EnterpriseBindingMapper: PresentationMapper<EnterpriseBinding, Enterprise> {

    override fun toDomain(presentation: EnterpriseBinding)= Enterprise (
        id = presentation.id,
        enterpriseName = presentation.enterpriseName,
        photo = presentation.photo,
        description = presentation.description,
        city = presentation.city,
        country = presentation.country,
        enterpriseType = EnterpriseTypeBindingMapper().toDomain(presentation.enterpriseType)
    )

    override fun fromDomain(domain: Enterprise)= EnterpriseBinding (
        id = domain.id,
        enterpriseName = domain.enterpriseName,
        photo = domain.photo,
        description = domain.description,
        city = domain.city,
        country = domain.country,
        enterpriseType = EnterpriseTypeBindingMapper().fromDomain(domain.enterpriseType)
    )
}