package com.example.pulsa.data.datasource.remote.model

import androidx.annotation.Keep

@Keep
data class PulsaPlansResponseApiModel(
    val message: String?,
    val products: List<ProductResponseApiModel>,
    val status: String
)

@Keep
data class ProductResponseApiModel(
    val bill_type: String,
    val description: String,
    val label: String,
    val nominal: String,
    val operator: String,
    val price: String,
    val product_code: String,
    val sequence: Int
)