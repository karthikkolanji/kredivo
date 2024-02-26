package com.example.pulsa.ui.datapackage

import androidx.lifecycle.ViewModel
import com.example.pulsa.domain.usecase.TopUpUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DataPackageViewModel @Inject constructor(private val topUpUseCase: TopUpUseCase) :
    ViewModel() {

}