package com.springdemo.api

import com.alibaba.fastjson.JSONObject
import com.auth0.jwt.JWT
import com.auth0.jwt.algorithms.Algorithm
import com.springdemo.service.AuthenticationService
import com.springdemo.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController

@RestController
class UserApi {
    @Autowired
    lateinit var userService: UserService
    @Autowired
    lateinit var authenticationService: AuthenticationService

    @PostMapping("/api/user")
    fun createUser(username: String, password: String) : String{
        userService.createUser(username, password)
        val token: String = JWT.create().withAudience(username)
                .sign(Algorithm.HMAC256(System.currentTimeMillis().toString()))
        authenticationService.createToken(username, token, "null", 3)
        val result = JSONObject()
        result.put("success", true)
        result.put("token", token)
        return result.toJSONString()
    }
}
