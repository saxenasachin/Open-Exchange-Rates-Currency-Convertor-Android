package com.sachinsaxena.openexchangerate.di.component

import com.sachinsaxena.common.di.component.CommonComponent
import com.sachinsaxena.openexchangerate.di.module.AppModule
import com.sachinsaxena.openexchangerate.di.module.RoomDatabaseModule
import com.sachinsaxena.openexchangerate.di.module.ViewModelModule
import com.sachinsaxena.openexchangerate.presentation.main.activity.CurrencyConvertorActivity
import dagger.Component
import javax.inject.Singleton


/**
Created by Sachin Saxena on 30/09/22.
 */
@Component(
    dependencies = [CommonComponent::class],
    modules = [
        ViewModelModule::class,
        RoomDatabaseModule::class,
        AppModule::class
    ]
)
@Singleton
interface OpenExchangeRateAppComponent {

    fun inject(activity: CurrencyConvertorActivity)
}