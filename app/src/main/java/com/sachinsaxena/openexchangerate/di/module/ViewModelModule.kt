package com.sachinsaxena.openexchangerate.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.sachinsaxena.common.di.scope.ViewModelKey
import com.sachinsaxena.openexchangerate.presentation.base.viewmodel.ViewModelFactory
import com.sachinsaxena.openexchangerate.presentation.main.viewmodel.CurrencyConvertorViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

/**
Created by Sachin Saxena on 30/09/22.
 */

@Module
abstract class ViewModelModule {

    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(CurrencyConvertorViewModel::class)
    internal abstract fun currencyConvertorViewModel(viewModel: CurrencyConvertorViewModel): ViewModel

    //Add more ViewModels here
}