package com.sso.ssoapi.dto

import com.querydsl.core.annotations.QueryProjection

data class PostDetail @QueryProjection constructor(
    val id: Long,
    val userId: Long,
    val content: String,
    val imageUrl: String?,
)