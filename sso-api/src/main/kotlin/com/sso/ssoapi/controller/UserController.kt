package com.sso.ssoapi.controller

import com.sso.ssoapi.controller.dto.UserLoginRequest
import com.sso.ssoapi.controller.dto.UserLoginResponse
import com.sso.ssoapi.dto.ApiResponse
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*

@Controller
@ResponseBody
@RequestMapping("/user")
//@CrossOrigin(origins = ["*"], allowedHeaders = ["*"])
class UserController {

    @GetMapping("/hello")
    fun hello(): ApiResponse {
        return ApiResponse("hello")
    }

    @PostMapping("/login")
    fun login(@RequestBody body: UserLoginRequest): ApiResponse {
        if (body.email === "fail") {
            return ApiResponse(UserLoginResponse(null))
        }
        return ApiResponse(UserLoginResponse("ok"))
    }

}