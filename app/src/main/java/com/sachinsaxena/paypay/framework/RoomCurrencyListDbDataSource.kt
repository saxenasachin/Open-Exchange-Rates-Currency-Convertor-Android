package com.sachinsaxena.paypay.framework

import android.content.Context
import com.sachinsaxena.common.data.CurrencyListDbDataSource
import com.sachinsaxena.common.domain.CurrencyDetails
import com.sachinsaxena.paypay.di.qualifier.ApplicationContext
import com.sachinsaxena.paypay.framework.db.CurrencyDetailEntity
import com.sachinsaxena.paypay.framework.db.OpenExchangeRateDatabase
import javax.inject.Inject

/**
Created by Sachin Saxena on 01/10/22.
 */
class RoomCurrencyListDbDataSource @Inject constructor(
    @ApplicationContext private val context: Context
) : CurrencyListDbDataSource {

    private val currencyDetailDao =
        OpenExchangeRateDatabase.getInstance(context).currencyDetailDao()

    override suspend fun addCurrencies(currencyDetailList: List<CurrencyDetails>) {
        return currencyDetailDao.addCurrencies(
            currencyDetailList.map {
                CurrencyDetailEntity(
                    code = it.code,
                    name = it.name
                )
            }
        )
    }

    override suspend fun readCurrencies(): List<CurrencyDetails> {
        return currencyDetailDao.getCurrencyList().map {
            CurrencyDetails(
                code = it.code,
                name = it.name
            )
        }
    }

    override suspend fun removeCurrencies() {
        return currencyDetailDao.removeCurrencies()
    }
}