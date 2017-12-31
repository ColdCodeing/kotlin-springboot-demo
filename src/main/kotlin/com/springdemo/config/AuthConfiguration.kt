package com.springdemo.config

import com.springdemo.interceptor.AuthInterceptor
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.InterceptorRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter

@Configuration
open class AuthConfiguration : WebMvcConfigurerAdapter() {

    override fun addInterceptors(registry: InterceptorRegistry?) {
        registry?.addInterceptor(authInterceptor())
                ?.addPathPatterns("/**")
        super.addInterceptors(registry)
    }

    @Bean
    open fun authInterceptor(): AuthInterceptor {
        return AuthInterceptor()
    }
}
