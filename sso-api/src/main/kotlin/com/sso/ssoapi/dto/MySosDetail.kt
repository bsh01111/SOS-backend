package com.sso.ssoapi.dto

import com.querydsl.core.annotations.QueryProjection
import com.sso.ssoapi.entity.SosUserApplyStatus

data class MySosDetail @QueryProjection constructor(
    val id: Long,
    val mainProfileUrl: String?,
    val content: String,
    val location: String,
    val cost: Long,
    val mediaUrl: String?,
    val userId: Long,
    val userNickname: String,
    val status: SosUserApplyStatus,
)