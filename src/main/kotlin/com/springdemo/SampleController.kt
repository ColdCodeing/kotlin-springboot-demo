package com.springdemo

import org.mybatis.spring.annotation.MapperScan
import java.text.SimpleDateFormat
import java.util.*
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
@MapperScan("com.springdemo.mapper")
open class SampleSpringBootApplication {
    //kotlin的类方法上没有static关键字,因此只有把main方法放在外面才有static关键字
}

fun main(args: Array<String>) {
    SpringApplication.run(SampleSpringBootApplication::class.java, *args)
    println("Hello, world!")
    println(SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Date()))
}

