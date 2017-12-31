package com.springdemo.service

import com.springdemo.mapper.TokenMapper
import com.springdemo.model.Token
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.sql.Date

@Service
class AuthenticationService {
    @Autowired
    lateinit var tokenMapper: TokenMapper

    fun createToken(username: String, token: String, authType: String, effectiveTime: Int) {
        val expirationTime = effectiveTime.times(60).times(60).times(1000)
        System.out.println("time out :" + Date(System.currentTimeMillis() + expirationTime))
        tokenMapper.insertToken(username, authType, token, Date(System.currentTimeMillis() + expirationTime))
    }

    fun checkToken(token: String) : Boolean{
        val tokenDb: Token? = tokenMapper.findByToken(token)
        val expiraTime = tokenDb?.expirationTime?.time ?: return false
        if (expiraTime > System.currentTimeMillis()) {
            return false
        }
        return true
    }
}
