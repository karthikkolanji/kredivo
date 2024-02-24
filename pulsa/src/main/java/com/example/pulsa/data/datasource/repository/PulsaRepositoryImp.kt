package com.example.pulsa.data.datasource.repository

import com.example.pulsa.data.datasource.remote.PulsaRemoteDataSource
import com.example.pulsa.data.datasource.repository.mapper.PulsaPlansResponseApiToDataMapper
import javax.inject.Inject

class PulsaRepositoryImp @Inject constructor(
    private val pulsaRemoteDataSource: PulsaRemoteDataSource,
    private val pulsaPlansResponseApiToDataMapper: PulsaPlansResponseApiToDataMapper
) : PulsaRepository {
    override suspend fun get() =
        pulsaPlansResponseApiToDataMapper.toData(pulsaRemoteDataSource.get())
}