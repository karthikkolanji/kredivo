package com.example.pulsa.ui.purchase

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.core.utils.ApiError
import com.example.core.utils.UiState.Loading
import com.example.core.utils.UiState.Success
import com.example.pulsa.domain.usecase.TopUpUseCase
import com.example.pulsa.ui.purchase.mapper.PlansItemResponseUiToDomainMapper
import com.example.pulsa.ui.purchase.mapper.PurchaseRequestUiToDomainMapper
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PurchaseViewModel @Inject constructor(
    private val topUpUseCase: TopUpUseCase,
    private val purchaseRequestUiToDomainMapper: PurchaseRequestUiToDomainMapper,
    private val plansItemResponseUiToDomainMapper: PlansItemResponseUiToDomainMapper
) :
    ViewModel() {

    suspend fun makePayment() = liveData {
        emit(Loading)
        try {
            emit(Success(topUpUseCase.makePayment()))
        } catch (exception: Exception) {
            emit(ApiError.resolveError(exception))
        }
    }

}