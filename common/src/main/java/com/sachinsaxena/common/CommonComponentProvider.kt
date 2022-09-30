package com.sachinsaxena.common

import com.sachinsaxena.common.di.component.CommonComponent

interface CommonComponentProvider {

    fun provideBaseComponent(): CommonComponent

}