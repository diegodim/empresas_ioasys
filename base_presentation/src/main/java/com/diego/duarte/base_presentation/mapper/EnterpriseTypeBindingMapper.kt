package com.diego.duarte.base_presentation.mapper

import com.diego.duarte.base_presentation.core.PresentationMapper
import com.diego.duarte.base_presentation.model.EnterpriseTypeBinding
import com.diego.duarte.domain.model.EnterpriseType

class EnterpriseTypeBindingMapper: PresentationMapper<EnterpriseTypeBinding, EnterpriseType> {

    override fun toDomain(presentation: EnterpriseTypeBinding)= EnterpriseType (
        id = presentation.id,
        enterpriseTypeName = presentation.enterpriseTypeName
    )

    override fun fromDomain(domain: EnterpriseType)= EnterpriseTypeBinding (
        id = domain.id,
        enterpriseTypeName = domain.enterpriseTypeName
    )
}