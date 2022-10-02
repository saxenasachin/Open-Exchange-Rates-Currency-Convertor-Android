package com.sachinsaxena.paypay.presentation.main.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.sachinsaxena.common.domain.CurrencyDetails
import com.sachinsaxena.common.domain.CurrencyRate
import com.sachinsaxena.common.interactors.CurrencyListApiInteractor
import com.sachinsaxena.common.interactors.CurrencyListDbInteractor
import com.sachinsaxena.common.interactors.CurrencyRatesApiInteractor
import com.sachinsaxena.common.interactors.CurrencyRatesDbInteractor
import com.sachinsaxena.paypay.PayPayApplication
import com.sachinsaxena.paypay.presentation.CurrencyConvertorDataState
import com.sachinsaxena.paypay.presentation.base.BaseViewModel
import com.sachinsaxena.paypay.utils.NetworkUtils
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

/**
Created by Sachin Saxena on 29/09/22.
 */
class CurrencyConvertorViewModel @Inject constructor(
    private val currencyListDbInteractor: CurrencyListDbInteractor,
    private val currencyListApiInteractor: CurrencyListApiInteractor,
    private val currencyRatesDbInteractor: CurrencyRatesDbInteractor,
    private val currencyRatesApiInteractor: CurrencyRatesApiInteractor
) : BaseViewModel<CurrencyConvertorDataState>() {

    override val stateObservable: MutableLiveData<CurrencyConvertorDataState> by lazy {
        MutableLiveData<CurrencyConvertorDataState>()
    }

    val loadingLiveData = MutableLiveData<Boolean>()
    val currencyDetailsListLiveData = MutableLiveData<List<CurrencyDetails>>()
    private var latestCurrencyRates = mutableListOf<CurrencyRate>()

    init {
        getCurrencies()
        getLatestRates()
    }

    val currencyDetailsFrom = MutableLiveData<CurrencyDetails>()

    private fun getLatestRates() {
        if (NetworkUtils.isConnected(PayPayApplication.INSTANCE)) {
            loadingLiveData.value = true
            viewModelScope.launch(Dispatchers.IO) {
                try {
                    val result = currencyRatesApiInteractor.invoke()
                    currencyRatesDbInteractor.addCurrencyRatesToDb(result)
                    latestCurrencyRates.clear()
                    latestCurrencyRates.addAll(result)
                    withContext(Dispatchers.Main) {
                        loadingLiveData.value = false
                    }
                } catch (e: Exception) {
                    e.printStackTrace()
                    withContext(Dispatchers.Main) {
                        loadingLiveData.value = false
                    }
                }
            }
        } else {
            getLatestRatesFromDb()
        }
    }

    private fun getLatestRatesFromDb() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val result = currencyRatesDbInteractor.getCurrencyRatesFromDb()
                latestCurrencyRates.clear()
                latestCurrencyRates.addAll(result)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    private fun getCurrencies() {
        if (NetworkUtils.isConnected(PayPayApplication.INSTANCE)) {
            loadingLiveData.value = true
            viewModelScope.launch(Dispatchers.IO) {
                try {
                    val result = currencyListApiInteractor.invoke()
                    currencyListDbInteractor.addCurrenciesToDb(result)
                    withContext(Dispatchers.Main) {
                        loadingLiveData.value = false
                        currencyDetailsListLiveData.value = result
                    }
                } catch (e: Exception) {
                    withContext(Dispatchers.Main) {
                        loadingLiveData.value = false
                    }
                    e.printStackTrace()
                }
            }
        } else {
            getCurrencyListFromDb()
        }
    }

    private fun getCurrencyListFromDb() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val result = currencyListDbInteractor.getCurrenciesFromDb()
                withContext(Dispatchers.Main) {
                    loadingLiveData.value = false
                    currencyDetailsListLiveData.value = result
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    fun getConvertedRate(value: Double, currencyFromCode: String, currencyToCode: String): Double {
        val currencyFromRateInDollar = latestCurrencyRates.find {
            it.code == currencyFromCode
        } ?: return 0.0
        val currencyToRateInDollar = latestCurrencyRates.find {
            it.code == currencyToCode
        } ?: return 0.0
        val ratio = currencyToRateInDollar.rate / currencyFromRateInDollar.rate
        return ratio * value
    }
}