package com.example.pulsa.domain.model

import androidx.annotation.Keep

@Keep
data class PaymentDetailsResponseDomainModel(
    val orderId: String,
    val merchantLogoUrl: String,
    val merchantName: String,
)
