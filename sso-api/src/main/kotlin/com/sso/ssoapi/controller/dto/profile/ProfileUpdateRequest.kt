package com.sso.ssoapi.controller.dto.profile

data class ProfileUpdateRequest (
    val career: String,
    val elementrySchool: String,
    val middleSchool: String,
    val highSchool: String,
    val university: String,
    val originPlace: String,
    val residence: String,
)