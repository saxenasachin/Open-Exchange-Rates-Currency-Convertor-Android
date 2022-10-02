package com.sachinsaxena.common.data.repository

import com.sachinsaxena.common.BuildConfig
import com.sachinsaxena.common.Network
import com.sachinsaxena.common.data.CurrencyDetailsApiDataSource
import com.sachinsaxena.common.domain.CurrencyDetails
import javax.inject.Inject

/**
Created by Sachin Saxena on 01/10/22.
 */
class CurrencyDetailsApiRepository @Inject constructor() : CurrencyDetailsApiDataSource {

    override suspend fun getCurrencyDetailsFromApi(): List<CurrencyDetails> {
        return Network.openExchangeRatesApiService.getCurrencies(BuildConfig.OPEN_EXCHANGE_APP_ID)
            .map {
                CurrencyDetails(
                    code = it.key,
                    name = it.value
                )
            }
    }

}