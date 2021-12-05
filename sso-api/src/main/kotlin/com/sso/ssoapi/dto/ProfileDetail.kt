package com.sso.ssoapi.dto

import com.querydsl.core.annotations.QueryProjection

data class ProfileDetail @QueryProjection constructor(
    val id: Long,
    val userId: Long,
    val userNickname: String,
    val mainProfileUrl: String?,
)