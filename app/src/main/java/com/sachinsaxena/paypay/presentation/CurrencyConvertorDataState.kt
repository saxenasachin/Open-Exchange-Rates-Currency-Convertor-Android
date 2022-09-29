package com.sachinsaxena.paypay.presentation

sealed class CurrencyConvertorDataState {

    object Init : CurrencyConvertorDataState()

    data class Loading(val message: String) : CurrencyConvertorDataState()

    data class Error(val message: String) : CurrencyConvertorDataState()
}