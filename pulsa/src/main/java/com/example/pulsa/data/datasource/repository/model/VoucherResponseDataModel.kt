package com.example.pulsa.data.datasource.repository.model

import androidx.annotation.Keep

@Keep
data class VoucherResponseDataModel(
    val data: List<DetailsResponseDataModel>,
    val status: String
)

@Keep
data class DetailsResponseDataModel(
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