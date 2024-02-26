package com.example.pulsa.ui.plans.mapper

import com.example.core.mapper.UiToDomainMapper
import com.example.pulsa.domain.model.PlansItemResponseDomainModel
import com.example.pulsa.ui.plans.model.PlansItemResponseUiModel
import javax.inject.Inject

class PlansItemResponseUiToDomainMapper @Inject constructor() :
    UiToDomainMapper<PlansItemResponseUiModel, PlansItemResponseDomainModel>() {
    override fun map(input: PlansItemResponseUiModel) = PlansItemResponseDomainModel(
        productCode = input.productCode,
        label = input.productName,
        price = input.rechargeAmount,
        nominal = input.talkTimeAmount,
    )
}