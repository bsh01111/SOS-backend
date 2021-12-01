package com.sso.ssoapi.dto

import com.querydsl.core.annotations.QueryProjection

data class SosDetail @QueryProjection constructor(
    val id: Long,
    val content: String,
    val location: String,
    val cost: Long,
    val mediaUrl: String?,
    val userId: Long,
    val userNickname: String,
)