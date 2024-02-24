package com.example.pulsa.domain.model

import androidx.annotation.Keep
import com.example.pulsa.data.datasource.remote.model.VoucherItemApiModel

@Keep
data class VoucherResponseDomainModel(
    val voucherItems: List<VoucherItemDomainModel>,
)

@Keep
data class VoucherItemDomainModel(
    val endDate: String,
    val howToUse: String,
    val imageUrl: String,
    val maxDiscount: String,
    val minTransactionAmount: String,
    val name: String,
    val percentage: Int,
    val startDate: String,
    val termsAndCondition: String,
    val usageCount: Int,
    val voucherCode: String
)