package com.example.pulsa.domain.model

data class PurchaseRequestDomainModel(
    val voucherApplied: Boolean,
    val voucherCode: String="",
    val rechargeAmount: Int,
    val discountAmount: Int=0,
    val maxDiscount: Int=0,
    val percentage:Int=0
)
