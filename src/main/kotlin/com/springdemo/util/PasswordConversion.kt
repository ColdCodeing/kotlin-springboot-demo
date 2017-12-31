package com.springdemo.util

import java.util.*

object PasswordConversion {

    open fun passwordToBase64(password: String) : String {
        return Base64.getEncoder().encodeToString(password.toByteArray())
    }

    open fun base64ToPassword(base64: String) : String {
        return String(Base64.getDecoder().decode(base64.toByteArray()))
    }
}
