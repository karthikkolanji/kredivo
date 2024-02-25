package com.example.pulsa.ui.voucher.mapper

import com.example.core.mapper.DomainToUiMapper
import com.example.pulsa.domain.model.VoucherItemDomainModel
import com.example.pulsa.ui.voucher.model.VoucherItemUiModel
import javax.inject.Inject

class VoucherItemResponseDomainToUiMapper @Inject constructor() :
    DomainToUiMapper<VoucherItemDomainModel, VoucherItemUiModel>() {
    override fun map(input: VoucherItemDomainModel) = VoucherItemUiModel(
        endDate = input.endDate,
        maxDiscount = input.maxDiscount,
        percentage = input.percentage,
        voucherCode = input.voucherCode
    )
}