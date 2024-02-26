package com.example.pulsa.domain.model

import androidx.annotation.Keep

@Keep
data class VoucherResponseDomainModel(
    val voucherItems: List<VoucherItemDomainModel>,
)

@Keep
data class VoucherItemDomainModel(
    val endDate: String,
    val maxDiscount: Int,
    val minTransactionAmount: Int,
    val name: String,
    val percentage: Int,
    val voucherCode: String,
    val isVoucherApplicable: Boolean = false
)