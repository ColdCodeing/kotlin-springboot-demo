package com.springdemo.util

import java.text.SimpleDateFormat
import java.util.*

object DateFormat {
    val dateFormat : SimpleDateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")

    fun currentTimeFormat() : String {
        return dateFormat.format(Date(System.currentTimeMillis()))
    }

    fun expriTimeFormat(hours: Int) : String {
        return dateFormat.format(Date(System.currentTimeMillis() + hours.minus(60).minus(60)))
    }
}
