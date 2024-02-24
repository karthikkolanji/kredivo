package com.example.pulsa.domain.model

data class ProductResponseDomainModel(
    val billType: String,
    val description: String,
    val label: String,
    val nominal: String,
    val operator: String,
    val price: String,
    val productCode: String,
    val sequence: Int
)