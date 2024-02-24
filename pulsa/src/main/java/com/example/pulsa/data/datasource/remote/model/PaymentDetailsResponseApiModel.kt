package com.example.pulsa.data.datasource.remote.model

import androidx.annotation.Keep

@Keep
data class PaymentDetailsResponseApiModel(
    val message: String,
    val status: String,
    val transaction_context: TransactionContextResponseApiModel
)

@Keep
data class TransactionContextResponseApiModel(
    val amount: String,
    val applied_payment_type: String,
    val checkout_amount: String,
    val expiration_time: String,
    val merchant_details: MerchantDetailsResponseApiModel,
    val order_id: String,
    val transaction_status: String,
    val transaction_token: String
)

@Keep
data class MerchantDetailsResponseApiModel(
    val logo_url: String,
    val name: String
)