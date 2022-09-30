package com.sachinsaxena.paypay.ui.main.di

import com.doubtnut.core.di.qualifier.ApiRetrofit
import com.sachinsaxena.common.network.OpenExchangeRatesApiService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
abstract class CurrencyConvertorActivityModule {

    @Module
    companion object {
        @Provides
        @JvmStatic
        fun provideSurveyService(@ApiRetrofit retrofit: Retrofit): OpenExchangeRatesApiService =
                retrofit.create(OpenExchangeRatesApiService::class.java)
    }

}