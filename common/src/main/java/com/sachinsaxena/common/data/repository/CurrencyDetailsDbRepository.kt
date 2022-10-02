package com.sachinsaxena.common.data.repository

import com.sachinsaxena.common.data.CurrencyListDbDataSource
import com.sachinsaxena.common.domain.CurrencyDetails
import javax.inject.Inject

/**
Created by Sachin Saxena on 01/10/22.
 */
class CurrencyDetailsDbRepository @Inject constructor(
    private val dataSource: CurrencyListDbDataSource
) {

    suspend fun addCurrencies(currencyDetailList: List<CurrencyDetails>) =
        dataSource.addCurrencies(currencyDetailList)

    suspend fun getCurrencies() = dataSource.readCurrencies()

    suspend fun removeCurrencies() = dataSource.removeCurrencies()
}