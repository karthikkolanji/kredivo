package com.example.pulsa.data.datasource.repository.mapper

import com.example.core.mapper.ApiToDataMapper
import com.example.pulsa.data.datasource.remote.model.VoucherResponseApiModel
import com.example.pulsa.data.datasource.repository.model.VoucherResponseDataModel
import javax.inject.Inject

class VoucherResponseApiToDataMapper @Inject constructor(private val voucherItemsApiToDataMapper: VoucherItemsApiToDataMapper) :
    ApiToDataMapper<VoucherResponseApiModel, VoucherResponseDataModel>() {
    override fun map(input: VoucherResponseApiModel) = VoucherResponseDataModel(
        voucherItems = input.voucherItem.map { voucherItemsApiToDataMapper.toData(it) }
    )
}