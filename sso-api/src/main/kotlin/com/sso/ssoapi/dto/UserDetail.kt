package com.sso.ssoapi.dto

import com.querydsl.core.annotations.QueryProjection

data class UserDetail @QueryProjection constructor(
    val id: Long,
    val nickname: String,
    val mainProfileUrl: String,
)