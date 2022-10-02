package com.sachinsaxena.openexchangerate.framework.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert

import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query

@Dao
interface CurrencyRateDao {

  @Insert(onConflict = REPLACE)
  suspend fun addCurrencyRate(currency: CurrencyRateEntity)

  @Insert(onConflict = REPLACE)
  suspend fun addCurrencyRates(currencyRates: List<CurrencyRateEntity>)

  @Query("SELECT * FROM currency_rates")
  suspend fun getCurrencyRateList(): List<CurrencyRateEntity>

  @Delete
  suspend fun removeCurrencyRate(currencyRate: CurrencyRateEntity)
}
