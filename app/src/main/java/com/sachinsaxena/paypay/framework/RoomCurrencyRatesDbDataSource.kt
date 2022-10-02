package com.sachinsaxena.paypay.framework

import android.content.Context
import com.sachinsaxena.common.data.CurrencyRateDbDataSource
import com.sachinsaxena.common.domain.CurrencyRate
import com.sachinsaxena.paypay.di.qualifier.ApplicationContext
import com.sachinsaxena.paypay.framework.db.CurrencyRateEntity
import com.sachinsaxena.paypay.framework.db.OpenExchangeRateDatabase
import javax.inject.Inject

/**
Created by Sachin Saxena on 01/10/22.
 */
class RoomCurrencyRatesDbDataSource @Inject constructor(
    @ApplicationContext private val context: Context
) : CurrencyRateDbDataSource {

    private val currencyRateDao =
        OpenExchangeRateDatabase.getInstance(context).currencyRateDao()

    override suspend fun addCurrencyRatesToDb(currencyRates: List<CurrencyRate>) {
        return currencyRateDao.addCurrencyRates(
            currencyRates = currencyRates.map {
                CurrencyRateEntity(
                    code = it.code,
                    rate = it.rate
                )
            })
    }

    override suspend fun getCurrencyRatesFromDb(): List<CurrencyRate> {
        return currencyRateDao.getCurrencyRateList().map {
            CurrencyRate(
                code = it.code,
                rate = it.rate
            )
        }
    }
}