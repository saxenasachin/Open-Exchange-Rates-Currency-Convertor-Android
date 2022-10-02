package com.sachinsaxena.common.di.component

import android.app.Application
import com.sachinsaxena.common.di.module.NetworkModule
import com.sachinsaxena.common.di.module.RepositoryModule
import dagger.BindsInstance
import dagger.Component

@Component(
    modules = [
        NetworkModule::class,
        RepositoryModule::class
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
}