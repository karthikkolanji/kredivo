package com.example.pulsa.data.datasource.repository.model

import androidx.annotation.Keep

@Keep
data class PulsaTransactionResponseDataModel(
    val message: String,
    val status: String,
    val transactionContext: TransactionContextResponseDataModel
)

@Keep
data class TransactionContextResponseDataModel(
    val amount: String,
    val appliedPaymentType: String,
    val checkoutAmount: String,
    val expirationTime: String,
    val merchantDetails: MerchantDetailsResponseDataModel,
    val orderId: String,
    val transactionStatus: String,
    val transactionToken: String
)

@Keep
data class MerchantDetailsResponseDataModel(
    val logoUrl: String,
    val name: String
)

