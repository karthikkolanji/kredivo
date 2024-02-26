package com.example.pulsa.ui.voucher.mapper

import com.example.core.mapper.DomainToUiMapper
import com.example.pulsa.domain.model.VoucherItemDomainModel
import com.example.pulsa.domain.model.VoucherResponseDomainModel
import com.example.pulsa.ui.voucher.model.VoucherResponseUiModelModel
import javax.inject.Inject

class VoucherResponseDomainToUiMapper @Inject constructor(private val voucherItemResponseDomainToUiMapper: VoucherItemResponseDomainToUiMapper) :
    DomainToUiMapper<List<VoucherItemDomainModel>, VoucherResponseUiModelModel>() {
    override fun map(input: List<VoucherItemDomainModel>) = VoucherResponseUiModelModel(
        voucherItems = input.map { voucherItemResponseDomainToUiMapper.toUi(it) }
    )
}