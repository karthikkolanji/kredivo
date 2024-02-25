package com.example.pulsa.domain.mapper

import com.example.core.mapper.DataToDomainMapper
import com.example.pulsa.data.datasource.repository.model.PlansItemResponseDataModel
import com.example.pulsa.domain.model.PlansItemResponseDomainModel
import javax.inject.Inject

class PlansResponseDataToDomainMapper @Inject constructor() :
    DataToDomainMapper<PlansItemResponseDataModel, PlansItemResponseDomainModel>() {
    override fun map(input: PlansItemResponseDataModel) = PlansItemResponseDomainModel(
        billType = input.billType,
        description = input.description,
        label = input.label,
        nominal = input.nominal,
        operator = input.operator,
        price = input.price,
        productCode = input.productCode,
        sequence = input.sequence
    )
}