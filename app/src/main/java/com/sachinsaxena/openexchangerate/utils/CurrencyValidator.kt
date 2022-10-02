package com.sachinsaxena.openexchangerate.utils

/**
Created by Sachin Saxena on 29/09/22.
 */
object CurrencyValidator {

    fun isValidAmountEntered(amount: CharSequence?): Boolean {
        if (amount.isNullOrBlank()) return false
        val amountInDouble = amount.toString().toDoubleOrNull() ?: return false
        return isValidAmount(amountInDouble)
    }

    fun isValidAmount(amount: Double?): Boolean {
        if (amount == null) return false
        if (amount <= 0.0) return false
        return true
    }

    fun isValidConversion(currencyFromCode: String, currencyToCode: String): Boolean =
        isValidCurrencyCode(currencyFromCode) && isValidCurrencyCode(currencyToCode) && currencyFromCode != currencyToCode


    fun isValidCurrencyCode(currencyCode: String?): Boolean =
        currencyCode.isNullOrBlank().not()
}