package com.sachinsaxena.paypay.di.module

import android.app.Application
import android.content.Context
import com.sachinsaxena.paypay.di.qualifier.ApplicationContext
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


/**
Created by Sachin Saxena on 02/10/22.
 */
@Module
class AppModule(private val application: Application) {

    @Provides
    @Singleton
    fun providesApplication(): Application = application

    @Provides
    @Singleton
    @ApplicationContext
    fun provideContext(application: Application): Context = application.applicationContext
}