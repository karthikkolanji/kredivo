package com.example.pulsa.ui.purchase.model

data class PurchaseRequestUiModel(
    val voucherApplied: Boolean,
    val voucherCode: String,
    val maxDiscount: Int,
    val discountPercentage: Int,
    val voucherValidity: String,
    val minTransactionAmount: Int
)
