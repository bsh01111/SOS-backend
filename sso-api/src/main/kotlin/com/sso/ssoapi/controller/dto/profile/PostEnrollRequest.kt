package com.sso.ssoapi.controller.dto.profile

data class PostEnrollRequest (
    val userId: Long,
    val content: String,
    val imageUrl: String,
)