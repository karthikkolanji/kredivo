package com.example.pulsa.domain.model

data class PlansItemResponseDomainModel(
    val label: String,
    val nominal: Int,
    val price: Int,
    val productCode: String,
    val krdivoDisount: Int = 0,
    val voucherApplied: Boolean = false
)