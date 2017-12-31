package com.springdemo.api

import com.alibaba.fastjson.JSONObject
import com.auth0.jwt.JWT
import com.auth0.jwt.algorithms.Algorithm
import com.springdemo.service.AuthenticationService
import com.springdemo.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
class AuthenticationApi {

    @Autowired
    lateinit var userService: UserService
    @Autowired
    lateinit var authenticationService : AuthenticationService


    @PostMapping("/springdemo/token")
    fun tokenCreate(@RequestParam("username", required = true) username: String,
                    @RequestParam("password", required = true) password: String) : String {
        if(!userService.checkPassword(username, password)) {
            throw Exception("登陆校验不通过")
        }
        val token: String = JWT.create().withAudience(username)
                .sign(Algorithm.HMAC256(System.currentTimeMillis().toString()))
        authenticationService.createToken(username, token, "null", 3)
        val result = JSONObject()
        result.put("success", true)
        result.put("token", token)
        return result.toJSONString()
    }
}
