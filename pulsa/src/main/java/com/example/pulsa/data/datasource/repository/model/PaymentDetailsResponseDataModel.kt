package com.example.pulsa.data.datasource.repository.model

import androidx.annotation.Keep

@Keep
data class PaymentDetailsResponseDataModel(
    val orderId: String,
    val status: String,
    val checkoutAmount:Int
)
