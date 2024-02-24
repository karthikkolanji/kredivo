package com.example.pulsa.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.core.utils.ApiError
import com.example.core.utils.UiState.Loading
import com.example.core.utils.UiState.Success
import com.example.pulsa.domain.usecase.PulsaPlansUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PulsaPlansViewModel @Inject constructor(private val pulsaPlansUseCase: PulsaPlansUseCase) :
    ViewModel() {

    suspend fun fetchPlans() = liveData {
        emit(Loading)
        try {
            emit(Success(pulsaPlansUseCase.get()))
        } catch (e: Exception) {
            emit(ApiError.resolveError(e))
        }
    }
}