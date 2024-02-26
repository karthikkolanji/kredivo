package com.example.pulsa.ui.voucher

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.core.di.DispatcherProvider
import com.example.core.utils.ApiError
import com.example.core.utils.UiState
import com.example.core.utils.UiState.Success
import com.example.pulsa.domain.model.PlansItemResponseDomainModel
import com.example.pulsa.domain.usecase.TopUpUseCase
import com.example.pulsa.ui.purchase.mapper.PlansItemResponseUiToDomainMapper
import com.example.pulsa.ui.voucher.mapper.VoucherItemResponseUiToDomainMapper
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class VoucherViewModel @Inject constructor(
    private val topUpUseCase: TopUpUseCase,
    private val plansItemResponseUiToDomainMapper: PlansItemResponseUiToDomainMapper,
    private val voucherItemResponseUiToDomainMapper: VoucherItemResponseUiToDomainMapper,
    private val dispatcherProvider: DispatcherProvider
) : ViewModel() {
    suspend fun getVoucher(selectedPlan: PlansItemResponseDomainModel) =
        liveData(dispatcherProvider.io()) {
            emit(UiState.Loading)
            try {
                val voucher = topUpUseCase.getVoucher(selectedPlan)
                emit(Success(voucher))
            } catch (e: Exception) {
                emit(ApiError.resolveError(e))
            }
        }
}