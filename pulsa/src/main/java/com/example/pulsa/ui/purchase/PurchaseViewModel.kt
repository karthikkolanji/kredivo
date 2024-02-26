package com.example.pulsa.ui.purchase

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.core.utils.ApiError
import com.example.core.utils.UiState.Loading
import com.example.core.utils.UiState.Success
import com.example.pulsa.domain.model.PlansItemResponseDomainModel
import com.example.pulsa.domain.model.PurchaseRequestDomainModel
import com.example.pulsa.domain.model.VoucherItemDomainModel
import com.example.pulsa.domain.usecase.TopUpUseCase
import com.example.pulsa.ui.plans.mapper.PlansItemResponseUiToDomainMapper
import com.example.pulsa.ui.purchase.mapper.PurchaseRequestUiToDomainMapper
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PurchaseViewModel @Inject constructor(
    private val topUpUseCase: TopUpUseCase,
) : ViewModel() {


    private val _voucherApplicationState = MutableLiveData<PurchaseRequestDomainModel>()
    val voucherApplicationState: LiveData<PurchaseRequestDomainModel> = _voucherApplicationState

    suspend fun applyVoucher(plan: PlansItemResponseDomainModel, voucher: VoucherItemDomainModel?) {
        val result = topUpUseCase.applyVoucher(plan, voucher)
        _voucherApplicationState.value = result

    }

    suspend fun removeVoucher(plan: PlansItemResponseDomainModel) {
        applyVoucher(plan, null)
    }

    suspend fun makePayment() = liveData {
        emit(Loading)
        try {
            emit(Success(topUpUseCase.makePayment()))
        } catch (exception: Exception) {
            emit(ApiError.resolveError(exception))
        }
    }


}