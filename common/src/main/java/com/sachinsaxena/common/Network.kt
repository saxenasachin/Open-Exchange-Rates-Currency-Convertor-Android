package com.sachinsaxena.common

import com.sachinsaxena.common.network.OpenExchangeRatesApiService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
Created by Sachin Saxena on 17/09/22.
 */
object Network {
    private const val TIMEOUT = 20L

    val openExchangeRatesApiService: OpenExchangeRatesApiService by lazy {
        buildRetrofit().create(OpenExchangeRatesApiService::class.java)
    }

    private fun getOkHttpClient(): OkHttpClient {
        return if (BuildConfig.DEBUG) {
            OkHttpClient.Builder()
                .connectTimeout(TIMEOUT, TimeUnit.SECONDS)
                .readTimeout(TIMEOUT, TimeUnit.SECONDS)
                .writeTimeout(TIMEOUT, TimeUnit.SECONDS)
                .addInterceptor(
                    HttpLoggingInterceptor().apply {
                        level = HttpLoggingInterceptor.Level.BODY
                    }
                )
                .build()
        } else OkHttpClient.Builder()
            .connectTimeout(TIMEOUT, TimeUnit.SECONDS)
            .readTimeout(TIMEOUT, TimeUnit.SECONDS)
            .writeTimeout(TIMEOUT, TimeUnit.SECONDS)
            .build()
    }

    private fun buildRetrofit(): Retrofit {
        return Retrofit.Builder().baseUrl(BuildConfig.BASE_URL)
            .client(getOkHttpClient())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}