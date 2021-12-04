package com.sso.ssoapi.dto

import com.querydsl.core.annotations.QueryProjection

data class ChattingRoomDetail @QueryProjection constructor(
    val id: Long,
    val userId: Long,
    val guestId: Long,
    val userNickname: String,
    val mainProfileurl: String,
)