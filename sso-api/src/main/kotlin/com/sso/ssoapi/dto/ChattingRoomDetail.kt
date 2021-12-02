package com.sso.ssoapi.dto

import com.querydsl.core.annotations.QueryProjection

data class ChattingRoomDetail @QueryProjection constructor(
    val id: Long,
    val userNickname: String,
    val userProfileurl: String,
)