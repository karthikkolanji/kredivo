package com.example.pulsa.ui.utils

import androidx.fragment.app.Fragment
import androidx.lifecycle.MutableLiveData
import androidx.navigation.fragment.findNavController
import com.example.pulsa.ui.voucher.model.VoucherItemResponseUiModel

const val VOUCHER_KEY="voucher"

fun Fragment.getNavigationResult(key: String ): MutableLiveData<VoucherItemResponseUiModel>? =
    findNavController().currentBackStackEntry?.savedStateHandle?.getLiveData(key)

fun Fragment.setNavigationResult(result: VoucherItemResponseUiModel, key: String ) {
    findNavController().previousBackStackEntry?.savedStateHandle?.set(key, result)
}

fun String.isValidMobileNumber()= length in 11..13