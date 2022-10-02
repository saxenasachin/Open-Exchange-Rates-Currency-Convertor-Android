package com.sachinsaxena.paypay

import android.app.Application
import com.sachinsaxena.common.CommonComponentProvider
import com.sachinsaxena.common.di.component.CommonComponent
import com.sachinsaxena.common.di.component.DaggerCommonComponent

/**
Created by Sachin Saxena on 30/09/22.
 */
class PayPayApplication : Application(), CommonComponentProvider {

    lateinit var daggerAppComponent: CommonComponent

    companion object {
        lateinit var INSTANCE: PayPayApplication
    }

    override fun onCreate() {
        super.onCreate()
        INSTANCE = this
        initialiseDaggerComponent()
    }

    private fun initialiseDaggerComponent() {
        daggerAppComponent = DaggerCommonComponent
            .builder()
            .application(this)
            .build()
            .also {
                it.inject(this)
            }
    }

    override fun provideBaseComponent(): CommonComponent {
        return daggerAppComponent
    }
}