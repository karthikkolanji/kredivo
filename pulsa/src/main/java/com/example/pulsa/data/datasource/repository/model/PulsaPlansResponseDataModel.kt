package com.example.pulsa.data.datasource.repository.model

import androidx.annotation.Keep

@Keep
data class PulsaPlansResponseDataModel(
    val message: String?,
    val plans: List<PlansItemResponseDataModel>,
    val status: String
)

@Keep
data class PlansItemResponseDataModel(
    val billType: String,
    val description: String,
    val label: String,
    val nominal: String,
    val operator: String,
    val price: String,
    val productCode: String,
    val sequence: Int
)