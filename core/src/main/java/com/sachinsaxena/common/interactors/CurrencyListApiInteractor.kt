package com.sachinsaxena.common.interactors

import com.sachinsaxena.common.data.repository.CurrencyDetailsApiRepository
import javax.inject.Inject

/**
Created by Sachin Saxena on 01/10/22.
 */
class CurrencyListApiInteractor @Inject constructor(private val currencyDetailsApiRepository: CurrencyDetailsApiRepository) {

    suspend operator fun invoke() = currencyDetailsApiRepository.getCurrencyDetailsFromApi()
}