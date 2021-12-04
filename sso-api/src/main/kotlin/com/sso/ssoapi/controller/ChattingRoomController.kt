package com.sso.ssoapi.controller

import com.sso.ssoapi.dto.ApiResponse
import com.sso.ssoapi.service.ChattingRoomService
import com.sso.ssoapi.controller.dto.chattingroom.ChattingRoomListResponse
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.RequestParam

@RestController
@RequestMapping("/chattingRoom")
class ChattingRoomController(
    private val chattingRoomService: ChattingRoomService
) {

    @GetMapping("/list")
    fun getChattingRoomListById(@RequestParam id: Long): ApiResponse {
        val chattingRoomList = chattingRoomService.findChattingRoomListById(id)
        return ApiResponse(ChattingRoomListResponse(chattingRoomList))
    }
}