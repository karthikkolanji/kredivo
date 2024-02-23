package com.example.core.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

const val BASE_URL = "https://run.mocky.io/v3/"

@Module
@InstallIn(SingletonComponent::class)
class RetrofitModule {

    @Provides
    @Singleton
    fun provideRetrofit(
        okHttpClient: OkHttpClient,
        gsonConverterFactory: GsonConverterFactory,
    ): Retrofit {
        return Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(BASE_URL)
            .addConverterFactory(gsonConverterFactory)
            .build()
    }
}


// pulsa - https://run.mocky.io/v3/21a9f0c5-34bc-445c-85fe-d020c5b95df3
// voucher - https://run.mocky.io/v3/df3a3b2c-9b6c-419d-bfc6-436d736e9664
// success - https://run.mocky.io/v3/cb3028bb-f2e1-4c94-914f-fbb3dca3f346