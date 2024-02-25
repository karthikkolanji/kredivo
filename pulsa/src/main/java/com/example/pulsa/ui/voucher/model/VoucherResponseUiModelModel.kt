package com.example.pulsa.ui.voucher.model

import androidx.annotation.Keep

@Keep
data class VoucherResponseUiModelModel(
    val voucherItems: List<VoucherItemUiModel>,
)

@Keep
data class VoucherItemUiModel(
    val endDate: String,
    val maxDiscount: String,
    val percentage: Int,
    val voucherCode: String
)