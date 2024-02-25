package com.example.pulsa.ui.voucher.mapper

import com.example.core.mapper.DomainToUiMapper
import com.example.pulsa.domain.model.VoucherResponseDomainModel
import com.example.pulsa.ui.voucher.model.VoucherResponseUiModelModel
import javax.inject.Inject

class VoucherResponseDomainToUiMapper @Inject constructor(private val voucherItemResponseDomainToUiMapper: VoucherItemResponseDomainToUiMapper) :
    DomainToUiMapper<VoucherResponseDomainModel, VoucherResponseUiModelModel>() {
    override fun map(input: VoucherResponseDomainModel) = VoucherResponseUiModelModel(
        voucherItems = input.voucherItems.map { voucherItemResponseDomainToUiMapper.toUi(it) }
    )
}