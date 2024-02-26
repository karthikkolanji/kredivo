package com.example.pulsa.ui.voucher.mapper

import com.example.core.extensions.convertDateFormat
import com.example.core.mapper.DomainToUiMapper
import com.example.pulsa.domain.model.VoucherItemDomainModel
import com.example.pulsa.ui.voucher.model.VoucherItemResponseUiModel
import javax.inject.Inject

class VoucherItemResponseDomainToUiMapper @Inject constructor() :
    DomainToUiMapper<VoucherItemDomainModel, VoucherItemResponseUiModel>() {
    override fun map(input: VoucherItemDomainModel) = VoucherItemResponseUiModel(
        endDate = input.endDate.convertDateFormat(),
        maxDiscount = input.maxDiscount,
        percentage = input.percentage,
        voucherCode = input.voucherCode,
        minTransactionAmount = input.minTransactionAmount,
        name = input.name,
        isVoucherApplicable = input.isVoucherApplicable
    )
}