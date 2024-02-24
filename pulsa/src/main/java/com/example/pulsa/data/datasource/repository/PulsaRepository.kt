package com.example.pulsa.data.datasource.repository

import com.example.pulsa.data.datasource.repository.model.PulsaPlansResponseDataModel

interface PulsaRepository {
    suspend fun get(): PulsaPlansResponseDataModel
}