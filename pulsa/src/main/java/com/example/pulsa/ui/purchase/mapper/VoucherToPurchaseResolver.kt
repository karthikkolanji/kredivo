package com.example.pulsa.ui.purchase.mapper

import com.example.pulsa.ui.purchase.model.PurchaseRequestUiModel
import com.example.pulsa.ui.voucher.model.VoucherItemUiModel
import javax.inject.Inject

class VoucherToPurchaseResolver @Inject constructor() {
    fun resolve(input: VoucherItemUiModel) = PurchaseRequestUiModel(
        voucherApplied = true,
        voucherCode = input.voucherCode,
    )
}