package com.sachinsaxena.openexchangerate.presentation.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

abstract class BaseViewModel<T> : ViewModel() {

    abstract val stateObservable: MutableLiveData<T>

    protected open fun publishState(state: T) {
        stateObservable.postValue(state)
    }
}
