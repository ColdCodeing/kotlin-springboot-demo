package com.springdemo.model

import java.sql.Timestamp

data class Token (var username: String, var token: String, var authType: String, var expirationTime: Timestamp)
