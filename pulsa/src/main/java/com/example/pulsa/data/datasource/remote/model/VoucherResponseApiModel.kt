package com.example.pulsa.data.datasource.remote.model

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class VoucherResponseApiModel(
    @SerializedName("data")
    val voucherItem: List<VoucherItemApiModel>,
    val status: String
)

@Keep
data class VoucherItemApiModel(
    val end_date: String,
    val how_to_use: String,
    val image_url: String,
    val max_discount: String,
    val min_transaction_amount: String,
    val name: String,
    val percentage: Int,
    val start_date: String,
    val terms_and_condition: String,
    val usage_count: Int,
    val voucher_code: String
)