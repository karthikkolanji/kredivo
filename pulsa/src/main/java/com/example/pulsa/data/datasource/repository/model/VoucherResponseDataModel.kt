package com.example.pulsa.data.datasource.repository.model

import androidx.annotation.Keep
import com.example.pulsa.data.datasource.remote.model.VoucherItemApiModel

@Keep
data class VoucherResponseDataModel(
    val voucherItems: List<VoucherItemDataModel>,
)

@Keep
data class VoucherItemDataModel(
    val endDate: String,
    val howToUse: String,
    val imageUrl: String,
    val maxDiscount: Int,
    val minTransactionAmount: Int,
    val name: String,
    val percentage: Int,
    val startDate: String,
    val termsAndCondition: String,
    val usageCount: Int,
    val voucherCode: String
)