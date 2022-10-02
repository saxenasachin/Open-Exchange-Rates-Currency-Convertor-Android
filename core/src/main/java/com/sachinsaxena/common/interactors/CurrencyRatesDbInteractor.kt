package com.sachinsaxena.common.interactors

import com.sachinsaxena.common.data.repository.CurrencyRateRepository
import com.sachinsaxena.common.domain.CurrencyRate
import javax.inject.Inject

/**
Created by Sachin Saxena on 01/10/22.
 */
class CurrencyRatesDbInteractor @Inject constructor(private val currencyRateRepository: CurrencyRateRepository) {

    suspend fun getCurrencyRatesFromDb() = currencyRateRepository.getCurrencyRatesFromDb()

    suspend fun addCurrencyRatesToDb(currencyRates: List<CurrencyRate>) =
        currencyRateRepository.addCurrencyRatesToDb(currencyRates = currencyRates)
}