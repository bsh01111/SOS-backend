package com.sso.ssoapi.controller.dto.user

import com.sso.ssoapi.entity.Sex
import java.util.*

data class UserSignUpRequest(
    val email: String,
    val password: String,
    val name: String,
    val nickname: String,
    val birthday: Date,
    val sex: Sex,
    val phoneNumber: String,
)
