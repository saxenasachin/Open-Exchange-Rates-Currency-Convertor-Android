package com.sachinsaxena.paypay.di.module

import android.content.Context
import com.sachinsaxena.common.data.CurrencyListDbDataSource
import com.sachinsaxena.common.data.CurrencyRateDbDataSource
import com.sachinsaxena.paypay.di.qualifier.ApplicationContext
import com.sachinsaxena.paypay.framework.RoomCurrencyListDbDataSource
import com.sachinsaxena.paypay.framework.RoomCurrencyRatesDbDataSource
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
Created by Sachin Saxena on 02/10/22.
 */
@Module
class RoomDatabaseModule {

    @Provides
    @Singleton
    fun provideRoomCurrencyDetailsDataSource(@ApplicationContext context: Context): CurrencyListDbDataSource =
        RoomCurrencyListDbDataSource(context)

    @Provides
    @Singleton
    fun provideRoomCurrencyRatesDataSource(@ApplicationContext context: Context): CurrencyRateDbDataSource =
        RoomCurrencyRatesDbDataSource(context)
}