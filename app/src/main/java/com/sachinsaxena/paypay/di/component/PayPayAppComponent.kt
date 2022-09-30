package com.sachinsaxena.paypay.di.component

import com.sachinsaxena.common.di.component.CommonComponent
import com.sachinsaxena.common.di.module.NetworkModule
import com.sachinsaxena.paypay.di.module.BindingActivityModule
import com.sachinsaxena.paypay.di.module.PayPayAppModule
import com.sachinsaxena.paypay.di.module.ViewModelModule
import com.sachinsaxena.paypay.presentation.main.activity.CurrencyConvertorActivity
import dagger.Component
import javax.inject.Singleton

/**
Created by Sachin Saxena on 30/09/22.
 */
@Component(
    dependencies = [CommonComponent::class],
    modules = [
        BindingActivityModule::class,
        NetworkModule::class,
        PayPayAppModule::class,
        ViewModelModule::class
    ]
)
@Singleton
interface PayPayAppComponent {

    fun inject(activity: CurrencyConvertorActivity)
}