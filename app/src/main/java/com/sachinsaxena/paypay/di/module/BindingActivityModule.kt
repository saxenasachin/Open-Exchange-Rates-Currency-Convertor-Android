package com.sachinsaxena.paypay.di.module

import com.doubtnut.core.di.scope.PerActivity
import com.sachinsaxena.paypay.presentation.main.activity.CurrencyConvertorActivity
import com.sachinsaxena.paypay.presentation.main.di.CurrencyConvertorActivityModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
Created by Sachin Saxena on 30/09/22.
 */
@Module
abstract class BindingActivityModule {
    @ContributesAndroidInjector(modules = [CurrencyConvertorActivityModule::class])
    @PerActivity
    internal abstract fun contributeCurrencyConvertorActivity(): CurrencyConvertorActivity
}