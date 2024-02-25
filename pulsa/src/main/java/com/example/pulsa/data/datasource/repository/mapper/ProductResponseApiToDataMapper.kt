package com.example.pulsa.data.datasource.repository.mapper

import com.example.core.mapper.ApiToDataMapper
import com.example.pulsa.data.datasource.remote.model.ProductResponseApiModel
import com.example.pulsa.data.datasource.repository.model.PlansItemResponseDataModel
import javax.inject.Inject

class ProductResponseApiToDataMapper @Inject constructor() :
    ApiToDataMapper<ProductResponseApiModel, PlansItemResponseDataModel>() {
    override fun map(input: ProductResponseApiModel) = PlansItemResponseDataModel(
        billType = input.bill_type,
        description = input.description,
        label = input.label,
        nominal = input.nominal,
        operator = input.operator,
        price = input.price,
        productCode = input.product_code,
        sequence = input.sequence
    )
}