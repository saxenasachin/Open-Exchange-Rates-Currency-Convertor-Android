package com.sachinsaxena.openexchangerate.framework.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query

@Dao
interface CurrencyDetailDao {

  @Insert(onConflict = REPLACE)
  suspend fun addCurrency(currency: CurrencyDetailEntity)

  @Insert(onConflict = REPLACE)
  suspend fun addCurrencies(currency: List<CurrencyDetailEntity>)

  @Query("SELECT * FROM currency_details")
  suspend fun getCurrencyList(): List<CurrencyDetailEntity>

  @Query("DELETE FROM currency_details")
  suspend fun removeCurrencies()
}
