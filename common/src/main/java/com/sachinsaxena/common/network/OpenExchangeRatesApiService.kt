package com.sachinsaxena.common.network

import com.sachinsaxena.common.domain.LatestCurrencyRates
import retrofit2.http.GET
import retrofit2.http.Query

/**
Created by Sachin Saxena on 29/09/22.
 */
interface OpenExchangeRatesApiService {

    @GET("latest.json")
    fun getLatestRates(
        @Query("app_id") appId: String
    ): LatestCurrencyRates

    @GET("currencies.json")
    suspend fun getCurrencies(
        @Query("app_id") appId: String
    ): Map<String, String>
}