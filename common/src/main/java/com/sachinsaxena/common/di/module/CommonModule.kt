package com.sachinsaxena.common.di.module

import com.doubtnut.core.di.qualifier.ApiRetrofit
import com.sachinsaxena.common.BuildConfig
import com.sachinsaxena.common.di.qualifier.DefaultOkHttpClient
import com.sachinsaxena.common.network.DatabaseService
import com.sachinsaxena.common.network.OpenExchangeRatesApiService
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

const val TIMEOUT = 20L

@Module
class CommonModule {
    @Provides
    @Singleton
    fun provideDatabaseService() = DatabaseService()

    @Provides
    @Singleton
    @DefaultOkHttpClient
    fun provideOkHttpClient(): OkHttpClient {
        return if (BuildConfig.DEBUG) {
            OkHttpClient.Builder()
                .connectTimeout(TIMEOUT, TimeUnit.SECONDS)
                .readTimeout(TIMEOUT, TimeUnit.SECONDS)
                .writeTimeout(TIMEOUT, TimeUnit.SECONDS)
                .addInterceptor(
                    HttpLoggingInterceptor().apply {
                        level = HttpLoggingInterceptor.Level.BODY
                    }
                )
                .build()
        } else OkHttpClient.Builder()
            .connectTimeout(TIMEOUT, TimeUnit.SECONDS)
            .readTimeout(TIMEOUT, TimeUnit.SECONDS)
            .writeTimeout(TIMEOUT, TimeUnit.SECONDS)
            .build()
    }

    @Provides
    @Singleton
    @ApiRetrofit
    fun provideRetroFit(
        @DefaultOkHttpClient okHttpClient: OkHttpClient,
    ): Retrofit {
        return Retrofit.Builder().baseUrl(BuildConfig.BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideNetworkService(@ApiRetrofit retrofit: Retrofit): OpenExchangeRatesApiService =
        retrofit.create(OpenExchangeRatesApiService::class.java)
}