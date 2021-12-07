package com.sso.ssoapi.dto

import com.querydsl.core.annotations.QueryProjection
import com.sso.ssoapi.entity.SosUserApplyStatus

data class ApplyDetail @QueryProjection constructor(
    val id: Long,
    val nickname: String,
    val mainProfileUrl: String,
    val status: SosUserApplyStatus,
)