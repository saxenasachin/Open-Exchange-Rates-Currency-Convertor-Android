package com.sachinsaxena.common.data

import com.sachinsaxena.common.domain.CurrencyRate

/**
Created by Sachin Saxena on 01/10/22.
 */
interface CurrencyRateApiDataSource {

    suspend fun getCurrencyRatesFromApi(): List<CurrencyRate>
}