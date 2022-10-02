package com.sachinsaxena.common.domain

import androidx.annotation.Keep

/**
Created by Sachin Saxena on 29/09/22.
 */
@Keep
data class CurrencyRate(
    val code: String,
    val rate: Double
)
