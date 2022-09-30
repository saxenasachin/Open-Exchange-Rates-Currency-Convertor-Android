package com.sachinsaxena.common.network

import com.sachinsaxena.common.model.LatestCurrencyRates
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

/**
Created by Sachin Saxena on 29/09/22.
 */
interface OpenExchangeRatesApiService {

    @GET("latest.json")
    fun getLatestRates(
        @Query("app_id") appId: String
    ): Call<LatestCurrencyRates>

    @GET("currencies.json")
    fun getCurrencies(
        @Query("app_id") appId: String
    ): Call<Map<String, String>>
}