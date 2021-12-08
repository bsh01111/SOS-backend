package com.sso.ssoapi.dto

import com.querydsl.core.annotations.QueryProjection
import com.sso.ssoapi.entity.SosUserApplyStatus

data class SosUserApplyDetail @QueryProjection constructor(
    val sosId: Long,
    val userId: Long,
    val userNickname: String,
    val mainProfileUrl: String?,
    val content: String,
    val location: String,
    val cost: Long,
    val status: SosUserApplyStatus,
)