package com.sachinsaxena.common.data.repository

import com.sachinsaxena.common.data.CurrencyRateDbDataSource
import com.sachinsaxena.common.domain.CurrencyRate
import javax.inject.Inject

/**
Created by Sachin Saxena on 01/10/22.
 */
class CurrencyRateRepository @Inject constructor(private val currencyRateDbDataSource: CurrencyRateDbDataSource) {

    suspend fun getCurrencyRatesFromDb() = currencyRateDbDataSource.getCurrencyRatesFromDb()

    suspend fun addCurrencyRatesToDb(currencyRates: List<CurrencyRate>) =
        currencyRateDbDataSource.addCurrencyRatesToDb(currencyRates = currencyRates)
}