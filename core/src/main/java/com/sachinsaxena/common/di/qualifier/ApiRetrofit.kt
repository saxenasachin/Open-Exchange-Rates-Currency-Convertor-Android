package com.doubtnut.core.di.qualifier

import javax.inject.Qualifier

/**
 * Created by Sachin Saxena on 30/09/2022.
 */
@Qualifier
@Target(AnnotationTarget.FIELD, AnnotationTarget.VALUE_PARAMETER, AnnotationTarget.FUNCTION, AnnotationTarget.PROPERTY_GETTER, AnnotationTarget.PROPERTY_SETTER)
@Retention(AnnotationRetention.RUNTIME)
annotation class ApiRetrofit