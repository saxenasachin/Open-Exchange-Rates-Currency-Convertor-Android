package com.sachinsaxena.paypay

import com.sachinsaxena.paypay.utils.CurrencyValidator
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */

@RunWith(JUnit4::class)
class CurrencyConversionUnitTest {

    @Test
    fun currencyValidator_CorrectAmountInput_ReturnsTrue() {
        assertTrue(CurrencyValidator.isValidAmountEntered("45.5"))
    }

    @Test
    fun currencyValidator_IncorrectAmountInputBlank_ReturnsFalse() {
        assertFalse(CurrencyValidator.isValidAmountEntered(""))
    }

    @Test
    fun currencyValidator_IncorrectAmountInputNull_ReturnsFalse() {
        assertFalse(CurrencyValidator.isValidAmountEntered(null))
    }

    @Test
    fun currencyValidator_CorrectAmountGreaterThan0_ReturnsTrue() {
        assertTrue(CurrencyValidator.isValidAmount(16.0))
    }

    @Test
    fun currencyValidator_IncorrectAmountLessThan0_ReturnsFalse() {
        assertFalse(CurrencyValidator.isValidAmount(-1.0))
    }

    @Test
    fun currencyValidator_IncorrectAmountEqualTo0_ReturnsFalse() {
        assertFalse(CurrencyValidator.isValidAmount(0.0))
    }

    @Test
    fun currencyValidator_IncorrectAmountNull_ReturnsFalse() {
        assertFalse(CurrencyValidator.isValidAmount(null))
    }

    @Test
    fun currencyValidator_CorrectCode_ReturnsTrue() {
        assertTrue(CurrencyValidator.isValidCurrencyCode("AED"))
    }

    @Test
    fun currencyValidator_IncorrectCodeBlank_ReturnsFalse() {
        assertFalse(CurrencyValidator.isValidCurrencyCode(""))
    }

    @Test
    fun currencyValidator_IncorrectCodeNull_ReturnsFalse() {
        assertFalse(CurrencyValidator.isValidCurrencyCode(null))
    }

    @Test
    fun currencyValidator_CorrectConversion_ReturnsFalse() {
        val currencyCodeFrom = "AED"
        val currencyCodeTo = "HTG"
        assertTrue(CurrencyValidator.isValidConversion(currencyCodeFrom, currencyCodeTo))
    }

    @Test
    fun currencyValidator_IncorrectConversion_ReturnsFalse() {
        val currencyCodeFrom = ""
        val currencyCodeTo = "HTG"
        assertFalse(CurrencyValidator.isValidConversion(currencyCodeFrom, currencyCodeTo))
    }
}