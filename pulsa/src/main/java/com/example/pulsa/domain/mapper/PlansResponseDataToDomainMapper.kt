package com.example.pulsa.domain.mapper

import com.example.core.mapper.DataToDomainMapper
import com.example.pulsa.data.datasource.repository.model.PlansItemResponseDataModel
import com.example.pulsa.domain.model.PlansItemResponseDomainModel
import javax.inject.Inject

class PlansResponseDataToDomainMapper @Inject constructor() :
    DataToDomainMapper<PlansItemResponseDataModel, PlansItemResponseDomainModel>() {
    override fun map(input: PlansItemResponseDataModel) = PlansItemResponseDomainModel(
        label = input.label,
        nominal = input.nominal.toInt(),
        price = input.price.toInt(),
        productCode = input.productCode,
    )
}