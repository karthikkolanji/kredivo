package com.example.pulsa.domain.mapper

import com.example.core.mapper.ApiToDataMapper
import com.example.core.mapper.DataToDomainMapper
import com.example.pulsa.data.datasource.repository.model.ProductResponseDataModel
import com.example.pulsa.domain.model.ProductResponseDomainModel
import javax.inject.Inject

class ProductResponseDataToDomainMapper @Inject constructor() :
    DataToDomainMapper<ProductResponseDataModel, ProductResponseDomainModel>() {
    override fun map(input: ProductResponseDataModel) = ProductResponseDomainModel(
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