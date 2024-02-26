package com.example.pulsa.ui.voucher.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


data class VoucherResponseUiModelModel(
    val voucherItems: List<VoucherItemResponseUiModel>,
)

@Parcelize
data class VoucherItemResponseUiModel(
    val name: String,
    val endDate: String,
    val maxDiscount: Int,
    val percentage: Int,
    val voucherCode: String,
    val minTransactionAmount: Int,
    val isVoucherApplicable: Boolean
) : Parcelable