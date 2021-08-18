package com.diego.duarte.data.factory

import com.diego.duarte.domain.model.Enterprise
import com.diego.duarte.domain.model.EnterpriseType

object EnterpriseFactory {

    val DUMMY_ENTERPRISE = Enterprise(
        id = 1,
        enterpriseName = "enterprise",
        photo = "photo.png",
        description = "asdfgh",
        city = "BH",
        country = "Brasil",
        enterpriseType = EnterpriseType(1, "Dev")
    )

    val DUMMY_ENTERPRISES =
        listOf(
        DUMMY_ENTERPRISE,
        DUMMY_ENTERPRISE,
        DUMMY_ENTERPRISE
        )

    const val DUMMY_QUERY = "asdf"
}