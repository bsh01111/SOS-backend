package com.sso.ssoapi.service

import com.sso.ssoapi.entity.ChattingRoom
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.server.ResponseStatusException
import com.sso.ssoapi.dto.ChattingRoomDetail
import com.sso.ssoapi.repository.ChattingRoomQueryDslRepository

@Service
class ChattingRoomService(
    private val chattingRoomQueryDslRepository: ChattingRoomQueryDslRepository
) {
    @Transactional(readOnly = true)
    fun findSosList(): List<ChattingRoomDetail> {
        return chattingRoomQueryDslRepository.findChattingRoomList()
    }
}