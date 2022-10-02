package com.sachinsaxena.common.interactors

import com.sachinsaxena.common.data.repository.CurrencyDetailsDbRepository
import com.sachinsaxena.common.domain.CurrencyDetails
import javax.inject.Inject

/**
Created by Sachin Saxena on 01/10/22.
 */
class CurrencyListDbInteractor @Inject constructor(private val currencyDetailsDbRepository: CurrencyDetailsDbRepository) {

    suspend fun getCurrenciesFromDb() = currencyDetailsDbRepository.getCurrencies()

    suspend fun addCurrenciesToDb(currencies: List<CurrencyDetails>) =
        currencyDetailsDbRepository.addCurrencies(currencies)
}