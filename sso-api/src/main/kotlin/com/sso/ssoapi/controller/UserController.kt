package com.sso.ssoapi.controller

import com.sso.ssoapi.dto.ApiResponse
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody

@Controller
@ResponseBody
@RequestMapping("/user")
class UserController {

    @GetMapping("/hello")
    fun hello(): ApiResponse {
        return ApiResponse("hello")
    }
}