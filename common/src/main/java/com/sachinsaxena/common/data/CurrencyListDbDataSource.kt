package com.sachinsaxena.common.data

import com.sachinsaxena.common.domain.CurrencyDetails

/**
Created by Sachin Saxena on 01/10/22.
 */
interface CurrencyListDbDataSource {

    suspend fun addCurrencies(currencyDetailList: List<CurrencyDetails>)

    suspend fun readCurrencies(): List<CurrencyDetails>

    suspend fun removeCurrencies()
}