package com.example.pulsa.ui.purchase.mapper

import com.example.pulsa.ui.purchase.model.PurchaseRequestUiModel
import com.example.pulsa.ui.voucher.model.VoucherItemResponseUiModel
import javax.inject.Inject

class VoucherToPurchaseResolver @Inject constructor() {
    fun resolve(input: VoucherItemResponseUiModel) = PurchaseRequestUiModel(
        voucherApplied = true,
        voucherCode = input.voucherCode,
        maxDiscount = input.maxDiscount,
        discountPercentage = input.percentage,
        voucherValidity = input.endDate,
        minTransactionAmount = input.minTransactionAmount
    )
}