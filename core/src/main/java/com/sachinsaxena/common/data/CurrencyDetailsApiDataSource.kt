package com.sachinsaxena.common.data

import com.sachinsaxena.common.domain.CurrencyDetails

/**
Created by Sachin Saxena on 01/10/22.
 */
interface CurrencyDetailsApiDataSource {

    suspend fun getCurrencyDetailsFromApi(): List<CurrencyDetails>
}