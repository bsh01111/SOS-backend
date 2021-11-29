package com.sso.ssoapi.controller

import com.sso.ssoapi.controller.dto.user.UserInfo
import com.sso.ssoapi.controller.dto.user.UserLoginRequest
import com.sso.ssoapi.controller.dto.user.UserLoginResponse
import com.sso.ssoapi.dto.ApiResponse
import com.sso.ssoapi.entity.User
import com.sso.ssoapi.service.UserService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping
class UserController(
    private val userService: UserService
) {

    @GetMapping("/user")
    private fun getUsers(): ResponseEntity<Any> {
        return ResponseEntity
            .ok()
            .body(userService.getAllUsers())
    }

    @PostMapping("/login")
    fun login(@RequestBody body: UserLoginRequest): ApiResponse {
        if (body.email == "fail") {
            return ApiResponse(UserLoginResponse(null))
        }
        return ApiResponse(UserLoginResponse(UserInfo(13, body.email)))
    }

    @GetMapping("/user/{id}")
    private fun getUserById(@PathVariable id: Int): ResponseEntity<Any> {
        return ResponseEntity
                .ok()
                .body(userService.getUser(id))
    }

    @PostMapping("/user")
    private fun postUser(@RequestBody user: User): ResponseEntity<Any> {
        userService.saveUser(user)
        return ResponseEntity
                .ok()
                .body(true)
    }
}