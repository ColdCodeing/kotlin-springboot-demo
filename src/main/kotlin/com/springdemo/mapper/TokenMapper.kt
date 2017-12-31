package com.springdemo.mapper

import com.springdemo.model.Token
import org.apache.ibatis.annotations.*
import java.util.*

@Mapper
interface TokenMapper {

    @Select("SELECT `username`, `auth_type`, `token`, `expiration_time` FROM `t_token` WHERE `token` = #{token}")
    fun findByToken(@Param("token") token: String) : Token

    @Insert("INSERT INTO `t_token` (`username`, `auth_type`, `token`, `expiration_time`) VALUES (#{username}, #{authType}, #{token}, #{time})")
    @Options(useGeneratedKeys=true, keyProperty="tid")
    fun insertToken(@Param("username") username: String,
                    @Param("authType") authType: String,
                    @Param("token") token: String,
                    @Param("time") time: Date) : Long

}
