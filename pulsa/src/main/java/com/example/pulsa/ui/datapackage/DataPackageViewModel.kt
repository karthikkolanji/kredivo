package com.example.pulsa.ui.datapackage

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.core.utils.ApiError
import com.example.core.utils.UiState.Loading
import com.example.core.utils.UiState.Success
import com.example.pulsa.domain.usecase.TopUpUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DataPackageViewModel @Inject constructor(private val topUpUseCase: TopUpUseCase) :
    ViewModel() {

    suspend fun fetchPlans() = liveData {
        emit(Loading)
        try {
            emit(Success(topUpUseCase.getPlans()))
        } catch (e: Exception) {
            emit(ApiError.resolveError(e))
        }
    }

    suspend fun makePayment() = liveData {
        emit(Loading)
        try {
            emit(Success(topUpUseCase.makePayment()))
        } catch (e: Exception) {
            emit(ApiError.resolveError(e))
        }
    }

    suspend fun getVoucher() = liveData {
        emit(Loading)
        try {
            emit(Success(topUpUseCase.getVoucher()))
        } catch (e: Exception) {
            emit(ApiError.resolveError(e))
        }
    }
}