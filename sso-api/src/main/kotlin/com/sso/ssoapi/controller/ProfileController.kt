package com.sso.ssoapi.controller

import com.sso.ssoapi.dto.ApiResponse
import com.sso.ssoapi.service.ProfileService
import com.sso.ssoapi.controller.dto.profile.ProfileDetailResponse
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/profile")
class ProfileController(
    private val profileService: ProfileService
) {
    @GetMapping("/{id}")
    fun getProfileDetail(@PathVariable id: Long): ApiResponse {
        val profile = profileService.findProfileDetail(id)
        return ApiResponse(ProfileDetailResponse(profile))
    }
}