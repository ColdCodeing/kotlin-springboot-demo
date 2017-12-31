package com.springdemo.service

import com.auth0.jwt.JWT
import com.auth0.jwt.algorithms.Algorithm
import com.springdemo.mapper.TokenMapper
import com.springdemo.mapper.UserMapper
import com.springdemo.model.User
import com.springdemo.util.PasswordConversion
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.PostMapping
import java.util.*

@Service
class UserService {
    @Autowired
    lateinit var userMapper: UserMapper
    @Autowired
    lateinit var tokenMapper: TokenMapper

    fun checkPassword(username: String, password: String) : Boolean {
        val passwordBase64: String  = PasswordConversion.passwordToBase64(password)
        val user: User? = userMapper.findByName(username)

        if (passwordBase64.equals(user?.password)) {
            return true
        }
        return false
    }

    fun  createUser(username: String, password: String) {
        val passwordBase64: String  = PasswordConversion.passwordToBase64(password)
        userMapper.insertUser(username, password)
    }
}
