package com.sachinsaxena.common

import android.content.Context
import com.sachinsaxena.common.di.component.CommonComponent

object InjectUtils {

    fun provideBaseComponent(applicationContext: Context): CommonComponent {
        return if (applicationContext is CommonComponentProvider) {
            (applicationContext as CommonComponentProvider).provideBaseComponent()
        } else {
            throw IllegalStateException("Provide the application context which implement BaseComponentProvider")
        }
    }

}