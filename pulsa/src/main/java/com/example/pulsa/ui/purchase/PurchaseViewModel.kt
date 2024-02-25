package com.example.pulsa.ui.purchase

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.core.utils.ApiError
import com.example.core.utils.UiState.Loading
import com.example.core.utils.UiState.Success
import com.example.pulsa.domain.usecase.TopUpUseCase
import com.example.pulsa.ui.purchase.model.PurchaseRequestUiModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PurchaseViewModel @Inject constructor(private val topUpUseCase: TopUpUseCase) :
    ViewModel() {

    private val _appliedVoucher = MutableLiveData<PurchaseRequestUiModel>()
    val appliedVoucher = _appliedVoucher
    fun applyVoucher(voucher: PurchaseRequestUiModel) {
        _appliedVoucher.postValue(voucher)
    }

    fun removeVoucher(voucher: PurchaseRequestUiModel) {
        _appliedVoucher.postValue(voucher)
    }

    suspend fun makePayment() = liveData {
        emit(Loading)
        try {
            emit(Success(topUpUseCase.makePayment()))
        } catch (e: Exception) {
            emit(ApiError.resolveError(e))
        }
    }

}