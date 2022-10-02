package com.sachinsaxena.common.data.repository

import com.sachinsaxena.common.BuildConfig
import com.sachinsaxena.common.Network
import com.sachinsaxena.common.data.CurrencyRateApiDataSource
import com.sachinsaxena.common.domain.CurrencyRate
import javax.inject.Inject

/**
Created by Sachin Saxena on 02/10/22.
 */
class CurrencyRateApiRepository @Inject constructor() : CurrencyRateApiDataSource {
    override suspend fun getCurrencyRatesFromApi(): List<CurrencyRate> {
        return Network.openExchangeRatesApiService.getLatestRates(BuildConfig.OPEN_EXCHANGE_APP_ID)
            .rates
            .map {
                CurrencyRate(
                    code = it.key,
                    rate = it.value
                )
            }
    }

}