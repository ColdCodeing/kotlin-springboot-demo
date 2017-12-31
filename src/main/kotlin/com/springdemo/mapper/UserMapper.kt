package com.springdemo.mapper

import com.springdemo.model.User
import org.apache.ibatis.annotations.*

@Mapper
interface UserMapper {

    @Select("SELECT `uid`, `username`, `password` FROM `t_user` WHERE `username` = #{username}")
    fun findByName(@Param("username") username: String) : User

    @Insert("INSERT INTO `t_user`(`username`, `password`) VALUES (#{username}, #{password})")
    @Options(useGeneratedKeys=true, keyProperty="uid")
    fun insertUser(@Param("username") username: String,
                   @Param("password") password: String) : Long

    @Update("UPDATE `t_user` SET `password` = #{newPass} WHERE `username` = #{username} AND `password` = #{originPass}")
    fun updateUser(@Param("newPass") newPass: String,
                   @Param("username") username: String,
                   @Param("originPass") originPass: String) : Int
}
