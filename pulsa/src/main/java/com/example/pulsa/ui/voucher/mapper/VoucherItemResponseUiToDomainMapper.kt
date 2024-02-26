package com.example.pulsa.ui.voucher.mapper

import com.example.core.extensions.convertDateFormat
import com.example.core.mapper.UiToDomainMapper
import com.example.pulsa.domain.model.VoucherItemDomainModel
import com.example.pulsa.ui.voucher.model.VoucherItemResponseUiModel
import javax.inject.Inject

class VoucherItemResponseUiToDomainMapper @Inject constructor() :
    UiToDomainMapper<VoucherItemResponseUiModel, VoucherItemDomainModel>() {
    override fun map(input: VoucherItemResponseUiModel) = VoucherItemDomainModel(
        name = input.name,
        endDate = input.endDate,
        maxDiscount = input.maxDiscount,
        percentage = input.percentage,
        voucherCode = input.voucherCode,
        minTransactionAmount = input.minTransactionAmount
    )
}