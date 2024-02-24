package com.example.pulsa.domain.mapper

import com.example.core.mapper.ApiToDataMapper
import com.example.core.mapper.DataToDomainMapper
import com.example.pulsa.data.datasource.remote.model.VoucherResponseApiModel
import com.example.pulsa.data.datasource.repository.model.VoucherResponseDataModel
import com.example.pulsa.domain.model.VoucherResponseDomainModel
import javax.inject.Inject

class VoucherResponseDataToDomainMapper @Inject constructor(private val voucherItemsDataToDomainMapper: VoucherItemsDataToDomainMapper) :
    DataToDomainMapper<VoucherResponseDataModel, VoucherResponseDomainModel>() {
    override fun map(input: VoucherResponseDataModel) = VoucherResponseDomainModel(
        voucherItems = input.voucherItems.map { voucherItemsDataToDomainMapper.toDomain(it) }
    )
}