package com.example.pulsa.ui.purchase.mapper

import com.example.core.mapper.UiToDomainMapper
import com.example.pulsa.domain.model.PurchaseRequestDomainModel
import com.example.pulsa.ui.purchase.model.PurchaseRequestUiModel
import javax.inject.Inject

class PurchaseRequestUiToDomainMapper @Inject constructor() :
    UiToDomainMapper<PurchaseRequestUiModel, PurchaseRequestDomainModel>() {
    override fun map(input: PurchaseRequestUiModel) = PurchaseRequestDomainModel(
        voucherApplied = input.voucherApplied,
        voucherCode = input.voucherCode,
        maxDiscount = input.maxDiscount,
        discountPercentage = input.discountPercentage,
        voucherValidity = input.voucherValidity,
        minTransactionAmount = input.minTransactionAmount
    )
}