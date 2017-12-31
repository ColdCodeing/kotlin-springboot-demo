package com.springdemo.controller

import com.springdemo.annotation.AuthRequire
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class IndexController {

    @AuthRequire
    @RequestMapping("/test")
    fun index() : String{
        return "ok"
    }
}
