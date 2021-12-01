package com.sso.ssoapi.dto

import com.querydsl.core.annotations.QueryProjection

data class UserDetail @QueryProjection constructor(
    val id: Long,
    val email: String,
    val name: String,
    val phoneNumber: String,
    val nickName: String,
    val birthDay: Date,
)