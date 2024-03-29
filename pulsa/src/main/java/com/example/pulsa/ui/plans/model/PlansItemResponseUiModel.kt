package com.example.pulsa.ui.plans.model

import android.os.Parcelable
import androidx.versionedparcelable.ParcelField
import kotlinx.parcelize.Parcelize
import java.math.BigDecimal

data class PlansResponseUiModel(
    val item: List<PlansItemResponseUiModel>
)

@Parcelize
data class PlansItemResponseUiModel(
    val productCode: String,
    val productName: String,
    val rechargeAmount: Int,
    val talkTimeAmount: Int,
    val mobileNumber: String = ""
) : Parcelable
