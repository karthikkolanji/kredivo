package com.example.pulsa.data.datasource.repository.mapper

import com.example.core.mapper.ApiToDataMapper
import com.example.pulsa.data.datasource.remote.model.PulsaPlansResponseApiModel
import com.example.pulsa.data.datasource.repository.model.PulsaPlansResponseDataModel
import javax.inject.Inject

class PulsaPlansResponseApiToDataMapper @Inject constructor(private val productResponseApiToDataMapper: ProductResponseApiToDataMapper) :
    ApiToDataMapper<PulsaPlansResponseApiModel, PulsaPlansResponseDataModel>() {
    override fun map(input: PulsaPlansResponseApiModel) = PulsaPlansResponseDataModel(
        message = input.message,
        products = input.products.map { productResponseApiToDataMapper.toData(it) },
        status = input.status
    )
}