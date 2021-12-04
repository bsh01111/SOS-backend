package com.sso.ssoapi.controller

import com.sso.ssoapi.controller.dto.user.UserLoginRequest
import com.sso.ssoapi.controller.dto.user.UserLoginResponse
import com.sso.ssoapi.controller.dto.user.UserSignUpRequest
import com.sso.ssoapi.controller.dto.user.UserSignUpResponse
import com.sso.ssoapi.controller.dto.user.UserListResponse
import com.sso.ssoapi.dto.ApiResponse
import com.sso.ssoapi.service.UserService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.RequestParam

@RestController
@RequestMapping("/user")
class UserController(
    private val userService: UserService
) {
    @PostMapping("/login")
    fun login(@RequestBody body: UserLoginRequest): ApiResponse {
        val user = userService.login(body.email, body.password)
        return ApiResponse(UserLoginResponse(user))
    }

    @PostMapping("/signUp")
    fun signUp(@RequestBody body: UserSignUpRequest): ApiResponse {
        val user = userService.signUp(body)
        return ApiResponse(UserSignUpResponse(user))
    }

    @GetMapping("/list")
    fun getUserList(@RequestParam id: Long): ApiResponse {
        val userList = userService.findUserList(id)
        return ApiResponse(UserListResponse(userList))
    }
}