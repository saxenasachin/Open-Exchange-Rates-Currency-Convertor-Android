package com.sachinsaxena.paypay.ui.main.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.sachinsaxena.common.base.BaseViewModel
import com.sachinsaxena.common.model.CurrencyDetails
import com.sachinsaxena.common.model.LatestCurrencyRates
import com.sachinsaxena.paypay.BuildConfig
import com.sachinsaxena.paypay.network.Network
import com.sachinsaxena.paypay.presentation.CurrencyConvertorDataState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
Created by Sachin Saxena on 29/09/22.
 */
class CurrencyConvertorViewModel() : BaseViewModel<CurrencyConvertorDataState>() {

    override val stateObservable: MutableLiveData<CurrencyConvertorDataState> by lazy {
        MutableLiveData<CurrencyConvertorDataState>()
    }

    val loading = MutableLiveData<Boolean>()
    val currencyDetailsListLiveData = MutableLiveData<List<CurrencyDetails>>()
    private var latestCurrencyRates = mutableMapOf<String, Double>()

    val currencyDetailsFrom = MutableLiveData<CurrencyDetails>()

    fun getLatestRates() {

        viewModelScope.launch(Dispatchers.IO) {
            val apiInterface =
                Network.openExchangeRatesApiService.getLatestRates(
                    appId = BuildConfig.OPEN_EXCHANGE_APP_ID
                )
            apiInterface.enqueue(object : Callback<LatestCurrencyRates> {
                override fun onResponse(
                    call: Call<LatestCurrencyRates>,
                    response: Response<LatestCurrencyRates>
                ) {
                    latestCurrencyRates = response.body()?.rates.orEmpty().toMutableMap()
                }

                override fun onFailure(call: Call<LatestCurrencyRates>, t: Throwable) {

                }
            })
        }
    }

    fun getCurrencies() {

        loading.value = true

        viewModelScope.launch(Dispatchers.IO) {
            val apiInterface =
                Network.openExchangeRatesApiService.getCurrencies(
                    appId = BuildConfig.OPEN_EXCHANGE_APP_ID
                )
            apiInterface.enqueue(object : Callback<Map<String, String>> {
                override fun onResponse(
                    call: Call<Map<String, String>>,
                    response: Response<Map<String, String>>
                ) {
                    val currencyMap = response.body().orEmpty()
                    val currencyDetailsLists: List<CurrencyDetails> = currencyMap.map {
                        val code = it.key
                        val name = it.value
                        CurrencyDetails(code, name)
                    }
                    loading.value = false

                    currencyDetailsListLiveData.value = currencyDetailsLists
                }

                override fun onFailure(call: Call<Map<String, String>>, t: Throwable) {
                    loading.value = false
                }
            })
        }
    }

    fun getConvertedRate(value: Double, currencyFromCode: String, currencyToCode: String): Double {
        val currencyFromRateInDollar = latestCurrencyRates[currencyFromCode] ?: return 0.0
        val currencyToRateInDollar = latestCurrencyRates[currencyToCode] ?: return 0.0
        val ratio = currencyToRateInDollar / currencyFromRateInDollar
        return ratio * value
    }
}