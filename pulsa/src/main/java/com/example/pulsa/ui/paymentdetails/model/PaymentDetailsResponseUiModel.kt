package com.example.pulsa.ui.paymentdetails.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class PaymentDetailsResponseUiModel(
    val orderId:String,
    val productName:String,
    val status:String,
    val mobileNumber:String,
    val rechargeAmount:Int,
    val subtotalAmount:Int,
    val payIn30DaysAmount:Int
): Parcelable
