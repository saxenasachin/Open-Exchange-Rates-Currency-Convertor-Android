package com.sachinsaxena.common.di.module

import com.sachinsaxena.common.data.CurrencyDetailsApiDataSource
import com.sachinsaxena.common.data.CurrencyListDbDataSource
import com.sachinsaxena.common.data.CurrencyRateApiDataSource
import com.sachinsaxena.common.data.CurrencyRateDbDataSource
import com.sachinsaxena.common.data.repository.CurrencyDetailsApiRepository
import com.sachinsaxena.common.data.repository.CurrencyDetailsDbRepository
import com.sachinsaxena.common.data.repository.CurrencyRateApiRepository
import com.sachinsaxena.common.data.repository.CurrencyRateRepository
import com.sachinsaxena.common.interactors.CurrencyListApiInteractor
import com.sachinsaxena.common.interactors.CurrencyListDbInteractor
import com.sachinsaxena.common.interactors.CurrencyRatesApiInteractor
import com.sachinsaxena.common.interactors.CurrencyRatesDbInteractor
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
Created by Sachin Saxena on 01/10/22.
 */
@Module
object RepositoryModule {

    @Singleton
    @Provides
    fun provideCurrencyDetailsInteractor(currencyDetailsDbRepository: CurrencyDetailsDbRepository): CurrencyListDbInteractor =
        CurrencyListDbInteractor(currencyDetailsDbRepository)

    @Singleton
    @Provides
    fun provideCurrencyDetailsRepository(
        dataSource: CurrencyListDbDataSource
    ): CurrencyDetailsDbRepository =
        CurrencyDetailsDbRepository(dataSource)

    @Singleton
    @Provides
    fun provideCurrencyRatesInteractor(currencyRateRepository: CurrencyRateRepository): CurrencyRatesDbInteractor =
        CurrencyRatesDbInteractor(currencyRateRepository)

    @Singleton
    @Provides
    fun provideCurrencyRatesRepository(dataSource: CurrencyRateDbDataSource): CurrencyRateRepository =
        CurrencyRateRepository(dataSource)

    @Singleton
    @Provides
    fun provideCurrencyDetailListApiInteractor(currencyDetailsApiRepository: CurrencyDetailsApiRepository): CurrencyListApiInteractor =
        CurrencyListApiInteractor(currencyDetailsApiRepository)

    @Singleton
    @Provides
    fun provideCurrencyDetailsApiRepository(): CurrencyDetailsApiDataSource =
        CurrencyDetailsApiRepository()

    @Singleton
    @Provides
    fun provideCurrencyRatesApiInteractor(currencyRateApiRepository: CurrencyRateApiRepository): CurrencyRatesApiInteractor =
        CurrencyRatesApiInteractor(currencyRateApiRepository)

    @Singleton
    @Provides
    fun provideCurrencyRateApiRepository(): CurrencyRateApiDataSource = CurrencyRateApiRepository()
}