package com.sachinsaxena.common.interactors

import com.sachinsaxena.common.data.repository.CurrencyRateApiRepository
import javax.inject.Inject

/**
Created by Sachin Saxena on 01/10/22.
 */
class CurrencyRatesApiInteractor @Inject constructor(private val currencyRatesApiRepository: CurrencyRateApiRepository) {

    suspend operator fun invoke() = currencyRatesApiRepository.getCurrencyRatesFromApi()
}