package com.example.pulsa.domain.mapper

import com.example.core.mapper.ApiToDataMapper
import com.example.core.mapper.DataToDomainMapper
import com.example.pulsa.data.datasource.remote.model.VoucherItemApiModel
import com.example.pulsa.data.datasource.repository.model.VoucherItemDataModel
import com.example.pulsa.domain.model.VoucherItemDomainModel
import javax.inject.Inject

class VoucherItemsDataToDomainMapper @Inject constructor() :
    DataToDomainMapper<VoucherItemDataModel,VoucherItemDomainModel>() {
    override fun map(input: VoucherItemDataModel) = VoucherItemDomainModel(
        endDate = input.endDate,
        maxDiscount = input.maxDiscount,
        minTransactionAmount = input.minTransactionAmount,
        name = input.name,
        percentage = input.percentage,
        voucherCode = input.voucherCode
    )
}