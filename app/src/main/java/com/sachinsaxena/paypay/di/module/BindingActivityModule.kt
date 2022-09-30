package com.sachinsaxena.paypay.di.module

import com.doubtnut.core.di.scope.PerActivity
import com.sachinsaxena.paypay.presentation.main.activity.CurrencyConvertorActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
Created by Sachin Saxena on 30/09/22.
 */
@Module
abstract class BindingActivityModule {
    @ContributesAndroidInjector
    @PerActivity
    internal abstract fun contributeCurrencyConvertorActivity(): CurrencyConvertorActivity
}