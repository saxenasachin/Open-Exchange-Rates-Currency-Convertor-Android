package com.sachinsaxena.common.di.component

import android.app.Application
import androidx.appcompat.app.AppCompatActivity
import com.sachinsaxena.common.di.module.NetworkModule
import dagger.BindsInstance
import dagger.Component

@Component(
    modules = [
        NetworkModule::class
    ]
)
interface CommonComponent {

    @Component.Builder
    interface Builder {

        fun build(): CommonComponent

        @BindsInstance
        fun application(application: Application): Builder
    }

    fun inject(app: Application)

    fun inject(baseBindingActivity: AppCompatActivity)
}