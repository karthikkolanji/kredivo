package com.example.pulsa.ui.voucher.model

import androidx.annotation.Keep

@Keep
data class VoucherResponseUiModelModel(
    val voucherItems: List<VoucherItemResponseUiModel>,
)

@Keep
data class VoucherItemResponseUiModel(
    val name:String,
    val endDate: String,
    val maxDiscount: Int,
    val percentage: Int,
    val voucherCode: String,
    val minTransactionAmount: Int,
    val isVoucherApplicable: Boolean
)