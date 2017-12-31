package com.springdemo.interceptor

import com.springdemo.annotation.AuthRequire
import com.springdemo.service.AuthenticationService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import org.springframework.web.method.HandlerMethod
import org.springframework.web.servlet.HandlerInterceptor
import org.springframework.web.servlet.ModelAndView
import java.lang.Exception
import java.lang.reflect.Method
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class AuthInterceptor : HandlerInterceptor{

    @Autowired
    lateinit var authenticationService: AuthenticationService

    override fun preHandle(request: HttpServletRequest?, response: HttpServletResponse?, handler: Any?): Boolean {
        System.out.println(request?.requestURI)
        val handlerMethod = handler as HandlerMethod
        val method: Method = handlerMethod.method
        val authRequired = method.getAnnotation(AuthRequire::class.java) ?: return true
        System.out.println(authRequired)
        val token: String = request?.getHeader("token") ?: throw Exception("no auth")
        if (authenticationService.checkToken(token)) {
            response?.sendError(401)
            return false
        }

        return true
    }

    override fun postHandle(request: HttpServletRequest?, response: HttpServletResponse?, handler: Any?, modelAndView: ModelAndView?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun afterCompletion(request: HttpServletRequest?, response: HttpServletResponse?, handler: Any?, ex: Exception?) {
    }
}
