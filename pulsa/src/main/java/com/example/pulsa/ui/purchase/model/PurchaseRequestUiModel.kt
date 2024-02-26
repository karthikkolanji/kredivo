package com.example.pulsa.ui.purchase.model

data class PurchaseRequestUiModel(
    val voucherApplied: Boolean,
    val voucherCode: String,
    val rechargeAmount: Int,
    val discountAmount: Int,
    val maxDiscount: Int,
    val discountPercentage:Int
)
