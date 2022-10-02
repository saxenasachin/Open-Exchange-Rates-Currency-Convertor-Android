package com.sachinsaxena.common.data

import com.sachinsaxena.common.domain.CurrencyRate

/**
Created by Sachin Saxena on 01/10/22.
 */
interface CurrencyRateDbDataSource {

    suspend fun addCurrencyRatesToDb(currencyRates: List<CurrencyRate>)

    suspend fun getCurrencyRatesFromDb(): List<CurrencyRate>
}