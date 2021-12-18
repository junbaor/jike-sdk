package com.github.junbaor.jike.model

data class PasswordLoginRequest (
    val areaCode: String,
    val mobilePhoneNumber: String,
    val password: String
)
