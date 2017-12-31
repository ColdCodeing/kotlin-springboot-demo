package com.springdemo.annotation

import java.lang.annotation.RetentionPolicy


@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION,
        AnnotationTarget.VALUE_PARAMETER, AnnotationTarget.EXPRESSION)
@Retention(AnnotationRetention.RUNTIME)
annotation class AuthRequire
