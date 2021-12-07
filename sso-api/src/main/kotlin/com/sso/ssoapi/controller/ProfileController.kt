package com.sso.ssoapi.controller

import com.sso.ssoapi.dto.ApiResponse
import com.sso.ssoapi.service.ProfileService
import com.sso.ssoapi.controller.dto.profile.ProfileDetailResponse
import com.sso.ssoapi.controller.dto.profile.PostListResponse
import com.sso.ssoapi.controller.dto.profile.PostEnrollRequest
import com.sso.ssoapi.controller.dto.profile.PostEnrollResponse
import com.sso.ssoapi.controller.dto.profile.ProfileUpdateRequest
import com.sso.ssoapi.controller.dto.profile.ProfileUpdateResponse
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
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

    @GetMapping("/post/{id}")
    fun getPostListByUserId(@PathVariable id: Long): ApiResponse {
        val postList = profileService.findPostListByUserId(id)
        return ApiResponse(PostListResponse(postList))
    }

    @PostMapping("/post")
    fun enrollPost(@RequestBody body: PostEnrollRequest): ApiResponse {
        val post = profileService.enrollPost(body)
        return ApiResponse(PostEnrollResponse(post))
    }

    @PutMapping("/{id}")
    fun updateProfile(@RequestBody body: ProfileUpdateRequest, @PathVariable id: Long): ApiResponse {
        val result = profileService.updateProfile(body, id)
        return ApiResponse(ProfileUpdateResponse(result))
    }
}