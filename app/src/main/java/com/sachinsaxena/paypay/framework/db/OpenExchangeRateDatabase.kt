package com.sachinsaxena.paypay.framework.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities = [CurrencyDetailEntity::class, CurrencyRateEntity::class],
    version = 1,
    exportSchema = false
)
abstract class OpenExchangeRateDatabase : RoomDatabase() {

    companion object {

        private const val DATABASE_NAME = "reader.db"

        private var instance: OpenExchangeRateDatabase? = null

        private fun create(context: Context): OpenExchangeRateDatabase =
            Room.databaseBuilder(context, OpenExchangeRateDatabase::class.java, DATABASE_NAME)
                .fallbackToDestructiveMigration()
                .build()


        fun getInstance(context: Context): OpenExchangeRateDatabase =
            (instance ?: create(context)).also { instance = it }
    }

    abstract fun currencyDetailDao(): CurrencyDetailDao

    abstract fun currencyRateDao(): CurrencyRateDao

}