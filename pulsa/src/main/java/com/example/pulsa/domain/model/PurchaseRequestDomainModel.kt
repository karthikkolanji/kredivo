package com.example.pulsa.domain.model

data class PurchaseRequestDomainModel(
    val voucherApplied: Boolean,
    val voucherCode: String,
    val maxDiscount: Int,
    val discountPercentage: Int,
    val voucherValidity: String,
    val minTransactionAmount: Int
)
