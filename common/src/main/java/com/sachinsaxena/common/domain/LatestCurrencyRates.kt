package com.sachinsaxena.common.domain

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

/**
Created by Sachin Saxena on 29/09/22.
 */
@Keep
data class LatestCurrencyRates(
    @SerializedName("rates")
    val rates: Map<String, Double>
)
