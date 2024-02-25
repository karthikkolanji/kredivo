package com.example.pulsa.ui.plans.mapper

import com.example.core.mapper.DomainToUiMapper
import com.example.pulsa.domain.model.PlansItemResponseDomainModel
import com.example.pulsa.ui.plans.model.PlansItemResponseUiModel
import javax.inject.Inject

class PlansItemResponseDomainToUiMapper @Inject constructor() :
    DomainToUiMapper<PlansItemResponseDomainModel, PlansItemResponseUiModel>() {
    override fun map(input: PlansItemResponseDomainModel) = PlansItemResponseUiModel(
        productCode = input.productCode,
        productName = input.label,
        rechargeAmount = input.price.toBigDecimal(),
        talkTimeAmount = input.nominal.toBigDecimal(),
    )
}