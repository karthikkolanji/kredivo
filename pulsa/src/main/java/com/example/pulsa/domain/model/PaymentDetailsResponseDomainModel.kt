package com.example.pulsa.domain.model

import androidx.annotation.Keep

@Keep
data class PaymentDetailsResponseDomainModel(
    val orderId: String,
    val status:String,
    val checkOutAmount:Int
)
